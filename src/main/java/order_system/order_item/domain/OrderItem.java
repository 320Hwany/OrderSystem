package order_system.order_item.domain;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record OrderItem(
        long orderItemId,
        long orderId,
        long itemId,
        long orderPrice,
        long orderQuantity,
        LocalDateTime createdAt,
        LocalDateTime lastModifiedAt
) {
}
