package order_system.order.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import order_system.global.BaseEntity;
import order_system.order.OrderStatus;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "orders")
@Entity
public class OrderJpaEntity extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    private Long memberId;

    private Long deliveryId;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Builder
    private OrderJpaEntity(final long memberId, final long deliveryId, final OrderStatus orderStatus) {
        this.memberId = memberId;
        this.deliveryId = deliveryId;
        this.orderStatus = orderStatus;
    }
}
