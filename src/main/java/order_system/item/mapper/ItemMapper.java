package order_system.item.mapper;

import order_system.item.domain.entity.ItemJpaEntity;
import order_system.item.mapper.dto.ItemSaveRequestDto;

public class ItemMapper {

    public static ItemJpaEntity toEntity(ItemSaveRequestDto dto) {
        return ItemJpaEntity.builder()
                .itemName(dto.itemName())
                .itemPrice(dto.itemPrice())
                .stockQuantity(dto.stockQuantity())
                .shoeSize(dto.shoeSize())
                .topSize(dto.topSize())
                .bottomSize(dto.bottomSize())
                .build();
    }
}
