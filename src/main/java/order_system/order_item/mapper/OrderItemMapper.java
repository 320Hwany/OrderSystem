package order_system.order_item.mapper;

import order_system.order_item.domain.OrderItem;
import order_system.order_item.domain.entity.OrderItemJpaEntity;
import order_system.order_item.mapper.dto.OrderItemSaveRequestDto;

public class OrderItemMapper {

    public static OrderItem toDomain(final OrderItemJpaEntity entity) {
        return OrderItem.builder()
                .orderItemId(entity.getId())
                .orderId(entity.getOrderId())
                .itemId(entity.getItemId())
                .orderPrice(entity.getOrderPrice())
                .orderQuantity(entity.getOrderQuantity())
                .build();
    }

    public static OrderItemJpaEntity toEntity(final long orderId, final OrderItemSaveRequestDto dto) {
        return OrderItemJpaEntity.builder()
                .orderId(orderId)
                .itemId(dto.itemId())
                .orderPrice(dto.orderPrice())
                .orderQuantity(dto.orderQuantity())
                .build();
    }
}
