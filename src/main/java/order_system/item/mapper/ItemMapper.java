package order_system.item.mapper;

import order_system.item.domain.Item;
import order_system.item.domain.entity.ItemJpaEntity;
import order_system.item.mapper.dto.ItemResponseDto;
import order_system.item.mapper.dto.ItemSaveRequestDto;

public class ItemMapper {

    public static Item toDomain(final ItemJpaEntity entity) {
        return Item.builder()
                .itemId(entity.getId())
                .itemName(entity.getItemName())
                .itemPrice(entity.getItemPrice())
                .stockQuantity(entity.getStockQuantity())
                .shoeSize(entity.getShoeSize())
                .topSize(entity.getTopSize())
                .bottomSize(entity.getBottomSize())
                .categoryType(entity.getCategoryType())
                .createdAt(entity.getCreatedAt())
                .lastModifiedAt(entity.getLastModifiedAt())
                .build();
    }

    public static ItemJpaEntity toEntity(final ItemSaveRequestDto dto) {
        return ItemJpaEntity.builder()
                .itemName(dto.itemName())
                .itemPrice(dto.itemPrice())
                .stockQuantity(dto.stockQuantity())
                .shoeSize(dto.shoeSize())
                .topSize(dto.topSize())
                .bottomSize(dto.bottomSize())
                .categoryType(dto.categoryType())
                .build();
    }

    public static ItemResponseDto toResponseDto(final Item item) {
        return ItemResponseDto.builder()
                .itemId(item.itemId())
                .itemName(item.itemName())
                .itemPrice(item.itemPrice())
                .stockQuantity(item.stockQuantity())
                .shoeSize(item.shoeSize())
                .topSize(item.topSize())
                .bottomSize(item.bottomSize())
                .categoryType(item.categoryType())
                .build();
    }
}
