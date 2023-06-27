package order_system.order.repository;

import order_system.order.domain.entity.OrderJpaEntity;

public interface OrderRepository {

    void save(final OrderJpaEntity entity);

    OrderJpaEntity getById(final long orderId);

    void deleteById(final long orderId);

    long count();
}
