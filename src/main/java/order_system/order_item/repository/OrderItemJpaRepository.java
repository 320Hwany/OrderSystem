package order_system.order_item.repository;

import order_system.order_item.domain.entity.OrderItemJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemJpaRepository extends JpaRepository<OrderItemJpaEntity, Long> {

    void deleteAllByOrderId(final long orderId);
}
