package order_system.item.repository;

import order_system.item.entity.ItemJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemJpaRepository extends JpaRepository<ItemJpaEntity, Long> {
}
