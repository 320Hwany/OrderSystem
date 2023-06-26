package order_system.item.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import order_system.global.BaseEntity;
import order_system.item.TopSize;

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

    private int shoeSize;

    @Enumerated(EnumType.STRING)
    private TopSize topSize;

    private int bottomSize;

    @Builder
    private ItemJpaEntity(final String itemName, final long itemPrice, final long stockQuantity,
                          final int shoeSize, final TopSize topSize, final int bottomSize) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.stockQuantity = stockQuantity;
        this.shoeSize = shoeSize;
        this.topSize = topSize;
        this.bottomSize = bottomSize;
    }
}
