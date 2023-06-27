package order_system.delivery.mapper;

import order_system.delivery.DeliveryStatus;
import order_system.delivery.domain.Delivery;
import order_system.delivery.domain.entity.DeliveryJpaEntity;

public class DeliveryMapper {

    public static DeliveryJpaEntity toEntity(DeliveryStatus deliveryStatus) {
        return DeliveryJpaEntity.builder()
                .deliveryStatus(deliveryStatus)
                .build();
    }

    public static Delivery toDomain(DeliveryJpaEntity entity) {
        return Delivery.builder()
                .deliveryId(entity.getId())
                .createdAt(entity.getCreatedAt())
                .lastModifiedAt(entity.getLastModifiedAt())
                .build();
    }
}
