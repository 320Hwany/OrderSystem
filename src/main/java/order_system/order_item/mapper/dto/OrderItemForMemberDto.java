package order_system.order_item.mapper.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import order_system.order.OrderStatus;

@Builder
public record OrderItemForMemberDto(
        long memberId,
        long orderId,
        long itemId,
        OrderStatus orderStatus,
        long orderPrice,
        long orderQuantity
) {
    @QueryProjection
    public OrderItemForMemberDto {
    }
}
