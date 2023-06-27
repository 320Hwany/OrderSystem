package order_system.order.application.command;

import order_system.delivery.DeliveryStatus;
import order_system.delivery.domain.Delivery;
import order_system.delivery.domain.entity.DeliveryJpaEntity;
import order_system.delivery.mapper.DeliveryMapper;
import order_system.delivery.repository.DeliveryRepository;
import order_system.order.OrderStatus;
import order_system.order.domain.Order;
import order_system.order.domain.entity.OrderJpaEntity;
import order_system.order.mapper.OrderMapper;
import order_system.order.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommandOrderSaveService {

    private final OrderRepository orderRepository;
    private final DeliveryRepository deliveryRepository;

    public CommandOrderSaveService(final OrderRepository orderRepository,
                                   final DeliveryRepository deliveryRepository) {
        this.orderRepository = orderRepository;
        this.deliveryRepository = deliveryRepository;
    }

    @Transactional
    public Order command(final long memberId) {
        Delivery delivery = saveDelivery();
        OrderJpaEntity entity = OrderMapper.toEntity(memberId, delivery.deliveryId(), OrderStatus.COMPLETE);
        orderRepository.save(entity);
        return OrderMapper.toDomain(entity);
    }

    // command 내부에서만 호출
    protected Delivery saveDelivery() {
        DeliveryJpaEntity entity = DeliveryMapper.toEntity(DeliveryStatus.DELIVERY);
        deliveryRepository.save(entity);
        return DeliveryMapper.toDomain(entity);
    }
}
