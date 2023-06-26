package order_system.order.domain;

import lombok.Builder;
import order_system.order.OrderStatus;

import java.time.LocalDateTime;

@Builder
public record Orders(
        long orderId,
        long memberId,
        long deliveryId,
        OrderStatus orderStatus,
        LocalDateTime createdAt,
        LocalDateTime lastModifiedAt
) {
}
