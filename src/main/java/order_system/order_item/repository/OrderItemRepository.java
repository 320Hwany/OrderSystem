package order_system.order_item.repository;

import order_system.order_item.domain.entity.OrderItemJpaEntity;

public interface OrderItemRepository {

    void save(final OrderItemJpaEntity entity);

    long count();
}
