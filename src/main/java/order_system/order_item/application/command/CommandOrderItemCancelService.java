package order_system.order_item.application.command;

import order_system.order.application.command.CommandOrderCancelService;
import order_system.order_item.repository.OrderItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CommandOrderItemCancelService {

    private final OrderItemRepository orderItemRepository;
    private final CommandOrderCancelService commandOrderCancelService;

    public CommandOrderItemCancelService(final OrderItemRepository orderItemRepository,
                                         final CommandOrderCancelService commandOrderCancelService) {
        this.orderItemRepository = orderItemRepository;
        this.commandOrderCancelService = commandOrderCancelService;
    }

    public void command(final long orderId) {
        commandOrderCancelService.command(orderId);
        orderItemRepository.deleteAllByOrderId(orderId);
    }
}
