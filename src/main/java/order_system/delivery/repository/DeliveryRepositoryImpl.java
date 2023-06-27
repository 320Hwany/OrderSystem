package order_system.delivery.repository;

import order_system.delivery.domain.entity.DeliveryJpaEntity;
import order_system.delivery.exception.DeliveryNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class DeliveryRepositoryImpl implements DeliveryRepository {

    private final DeliveryJpaRepository deliveryJpaRepository;

    public DeliveryRepositoryImpl(final DeliveryJpaRepository deliveryJpaRepository) {
        this.deliveryJpaRepository = deliveryJpaRepository;
    }

    @Override
    public void save(final DeliveryJpaEntity entity) {
        deliveryJpaRepository.save(entity);
    }

    @Override
    public DeliveryJpaEntity getById(final long deliveryId) {
        return deliveryJpaRepository.findById(deliveryId)
                .orElseThrow(DeliveryNotFoundException::new);
    }

    @Override
    public void deleteById(final long deliveryId) {
        deliveryJpaRepository.deleteById(deliveryId);
    }

    @Override
    public long count() {
        return deliveryJpaRepository.count();
    }
}
