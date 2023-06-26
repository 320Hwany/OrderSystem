package order_system.item.domain;

import lombok.Builder;
import order_system.item.TopSize;

import java.time.LocalDateTime;

@Builder
public record Item(
        long itemId,
        String itemName,
        long itemPrice,
        long stockQuantity,
        int shoeSize,
        TopSize topSize,
        int bottomSize,
        LocalDateTime createdAt,
        LocalDateTime lastModifiedAt
) {
}
