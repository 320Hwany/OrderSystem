package order_system.delivery.repository;

import order_system.delivery.domain.entity.DeliveryJpaEntity;

public interface DeliveryRepository {

    void save(final DeliveryJpaEntity entity);

    DeliveryJpaEntity getById(final long deliveryId);

    long count();
}
