package order_system.delivery.domain;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record Delivery(
        long deliveryId,
        LocalDateTime createdAt,
        LocalDateTime lastModifiedAt
) {
}
