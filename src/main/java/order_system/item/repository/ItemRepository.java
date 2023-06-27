package order_system.item.repository;

import order_system.item.domain.entity.ItemJpaEntity;

public interface ItemRepository {

    void save(final ItemJpaEntity entity);

    ItemJpaEntity getById(final long itemId);

    long count();
}
