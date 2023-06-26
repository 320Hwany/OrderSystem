package order_system.delivery.repository;

import order_system.delivery.entity.DeliveryJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryJpaRepository extends JpaRepository<DeliveryJpaEntity, Long> {
}
