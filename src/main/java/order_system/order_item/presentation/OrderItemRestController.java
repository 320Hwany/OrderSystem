package order_system.order_item.presentation;

import order_system.global.annotation.Login;
import order_system.member.domain.MemberSession;
import order_system.order_item.application.command.CommandOrderItemSaveService;
import order_system.order_item.application.query.QueryOrderItemByMemberIdService;
import order_system.order_item.mapper.dto.OrderItemForMemberDto;
import order_system.order_item.mapper.dto.OrderItemResponseResultDto;
import order_system.order_item.mapper.dto.OrderItemSaveRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class OrderItemRestController {

    private final CommandOrderItemSaveService commandOrderItemSaveService;
    private final QueryOrderItemByMemberIdService queryOrderItemByMemberIdService;

    public OrderItemRestController(final CommandOrderItemSaveService commandOrderItemSaveService,
                                   final QueryOrderItemByMemberIdService queryOrderItemByMemberIdService) {
        this.commandOrderItemSaveService = commandOrderItemSaveService;
        this.queryOrderItemByMemberIdService = queryOrderItemByMemberIdService;
    }

    @PostMapping("/orderItem")
    public void save(@Login final MemberSession memberSession,
                     @RequestBody final OrderItemSaveRequestDto dto) {
        commandOrderItemSaveService.command(memberSession.getMemberId(), dto);
    }

    @GetMapping("/orderItem")
    public OrderItemResponseResultDto get(@Login final MemberSession memberSession) {
        List<OrderItemForMemberDto> dtos = queryOrderItemByMemberIdService.query(memberSession.getMemberId());
        return new OrderItemResponseResultDto(dtos);
    }
}
