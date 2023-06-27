package order_system.item.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import order_system.global.BaseEntity;
import order_system.item.enumtype.BottomSize;
import order_system.item.enumtype.CategoryType;
import order_system.item.enumtype.ShoeSize;
import order_system.item.enumtype.TopSize;
import order_system.item.mapper.dto.ItemUpdateRequestDto;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "item")
@Entity
public class ItemJpaEntity extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    private String itemName;

    private long itemPrice;

    private long stockQuantity;

    @Enumerated(EnumType.STRING)
    private ShoeSize shoeSize;

    @Enumerated(EnumType.STRING)
    private TopSize topSize;

    @Enumerated(EnumType.STRING)
    private BottomSize bottomSize;

    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;

    @Builder
    private ItemJpaEntity(final String itemName, final long itemPrice, final long stockQuantity,
                         final ShoeSize shoeSize, final TopSize topSize, final BottomSize bottomSize,
                         final CategoryType categoryType) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.stockQuantity = stockQuantity;
        this.shoeSize = shoeSize;
        this.topSize = topSize;
        this.bottomSize = bottomSize;
        this.categoryType = categoryType;
    }

    public void update(final ItemUpdateRequestDto dto) {
        this.itemName = dto.itemName();
        this.itemPrice = dto.itemPrice();
        this.stockQuantity = dto.stockQuantity();
        this.shoeSize = dto.shoeSize();
        this.topSize = dto.topSize();
        this.bottomSize = dto.bottomSize();
        this.categoryType = dto.categoryType();
    }
}
