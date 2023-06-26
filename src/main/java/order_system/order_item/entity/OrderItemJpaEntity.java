package order_system.order_item.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import order_system.global.BaseEntity;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "order_item")
@Entity
public class OrderItemJpaEntity extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long id;

    private Long orderId;

    private Long itemId;

    private long orderPrice;

    private long orderQuantity;

    @Builder
    private OrderItemJpaEntity(final long orderId, final long itemId,
                               final long orderPrice, final long orderQuantity) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.orderPrice = orderPrice;
        this.orderQuantity = orderQuantity;
    }
}
