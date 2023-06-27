package order_system.order_item.presentation;

import order_system.global.annotation.Login;
import order_system.member.domain.MemberSession;
import order_system.order_item.application.command.CommandOrderItemSaveService;
import order_system.order_item.mapper.dto.OrderItemSaveRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class OrderItemRestController {

    private final CommandOrderItemSaveService commandOrderItemSaveService;

    public OrderItemRestController(final CommandOrderItemSaveService commandOrderItemSaveService) {
        this.commandOrderItemSaveService = commandOrderItemSaveService;
    }

    @PostMapping("/orderItem")
    public void save(@Login final MemberSession memberSession,
                     @RequestBody final OrderItemSaveRequestDto dto) {
        commandOrderItemSaveService.command(memberSession.getMemberId(), dto);
    }
}
