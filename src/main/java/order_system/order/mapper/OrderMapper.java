package order_system.order.mapper;

import order_system.order.OrderStatus;
import order_system.order.domain.Order;
import order_system.order.domain.entity.OrderJpaEntity;

public class OrderMapper {

    public static OrderJpaEntity toEntity(final long memberId, long deliveryId,
                                          final OrderStatus orderStatus) {
        return OrderJpaEntity.builder()
                .memberId(memberId)
                .deliveryId(deliveryId)
                .orderStatus(orderStatus)
                .build();
    }

    public static Order toDomain(final OrderJpaEntity entity) {
        return Order.builder()
                .orderId(entity.getId())
                .memberId(entity.getMemberId())
                .deliveryId(entity.getDeliveryId())
                .orderStatus(entity.getOrderStatus())
                .createdAt(entity.getCreatedAt())
                .lastModifiedAt(entity.getLastModifiedAt())
                .build();
    }
}
