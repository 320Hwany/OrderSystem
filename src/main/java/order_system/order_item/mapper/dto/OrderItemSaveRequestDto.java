package order_system.order_item.mapper.dto;

import lombok.Builder;


@Builder
public record OrderItemSaveRequestDto(
        long itemId,
        long orderPrice,
        long orderQuantity
) {
}
