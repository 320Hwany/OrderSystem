package order_system.order_item.mapper.dto;

import java.util.List;

public record OrderItemResponseResultDto(
        List<OrderItemForMemberDto> orderItemForMemberDtos
) {
}
