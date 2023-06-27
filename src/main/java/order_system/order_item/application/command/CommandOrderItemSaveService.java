package order_system.order_item.application.command;

import order_system.order.application.command.CommandOrderSaveService;
import order_system.order.domain.Order;
import order_system.order_item.domain.OrderItem;
import order_system.order_item.domain.entity.OrderItemJpaEntity;
import order_system.order_item.mapper.OrderItemMapper;
import order_system.order_item.mapper.dto.OrderItemSaveRequestDto;
import order_system.order_item.repository.OrderItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CommandOrderItemSaveService {

    private final OrderItemRepository orderItemRepository;
    private final CommandOrderSaveService commandOrderSaveService;

    public CommandOrderItemSaveService(final OrderItemRepository orderItemRepository,
                                       final CommandOrderSaveService commandOrderSaveService) {
        this.orderItemRepository = orderItemRepository;
        this.commandOrderSaveService = commandOrderSaveService;
    }

    public OrderItem command(final long memberId, final OrderItemSaveRequestDto dto) {
        Order order = commandOrderSaveService.command(memberId);
        OrderItemJpaEntity entity = OrderItemMapper.toEntity(order.orderId(), dto);
        orderItemRepository.save(entity);
        return OrderItemMapper.toDomain(entity);
    }
}
