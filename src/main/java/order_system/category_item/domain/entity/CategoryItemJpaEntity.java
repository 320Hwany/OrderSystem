package order_system.category_item.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import order_system.global.BaseEntity;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "category_item")
@Entity
public class CategoryItemJpaEntity extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_item_id")
    private Long id;

    private Long itemId;

    private Long categoryId;

    @Builder
    private CategoryItemJpaEntity(final long itemId, final long categoryId) {
        this.itemId = itemId;
        this.categoryId = categoryId;
    }
}
