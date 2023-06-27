package order_system.item.domain;

import lombok.Builder;
import order_system.item.enumtype.BottomSize;
import order_system.item.enumtype.CategoryType;
import order_system.item.enumtype.ShoeSize;
import order_system.item.enumtype.TopSize;

import java.time.LocalDateTime;

@Builder
public record Item(
        long itemId,
        String itemName,
        long itemPrice,
        long stockQuantity,
        ShoeSize shoeSize,
        TopSize topSize,
        BottomSize bottomSize,
        CategoryType categoryType,
        LocalDateTime createdAt,
        LocalDateTime lastModifiedAt
) {
}
