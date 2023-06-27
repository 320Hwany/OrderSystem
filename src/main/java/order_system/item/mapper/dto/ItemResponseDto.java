package order_system.item.mapper.dto;

import lombok.Builder;
import order_system.item.enumtype.BottomSize;
import order_system.item.enumtype.ShoeSize;
import order_system.item.enumtype.TopSize;

@Builder
public record ItemResponseDto(
        long itemId,
        String itemName,
        long itemPrice,
        long stockQuantity,
        ShoeSize shoeSize,
        TopSize topSize,
        BottomSize bottomSize
) {
}
