package order_system.category_item.repository;

import order_system.category_item.domain.entity.CategoryItemJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryItemJpaRepository extends JpaRepository<CategoryItemJpaEntity, Long> {
}
