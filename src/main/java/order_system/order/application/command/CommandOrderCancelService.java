package order_system.order.application.command;

import order_system.delivery.repository.DeliveryRepository;
import order_system.order.domain.entity.OrderJpaEntity;
import order_system.order.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CommandOrderCancelService {

    private final OrderRepository orderRepository;
    private final DeliveryRepository deliveryRepository;

    public CommandOrderCancelService(final OrderRepository orderRepository,
                                     final DeliveryRepository deliveryRepository) {
        this.orderRepository = orderRepository;
        this.deliveryRepository = deliveryRepository;
    }

    public void command(final long orderId) {
        OrderJpaEntity entity = orderRepository.getById(orderId);
        deliveryRepository.deleteById(entity.getDeliveryId());
        orderRepository.deleteById(orderId);
    }
}
