package order_system.item.repository;

import order_system.item.domain.entity.ItemJpaEntity;
import order_system.item.exception.ItemNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    private final ItemJpaRepository itemJpaRepository;

    public ItemRepositoryImpl(final ItemJpaRepository itemJpaRepository) {
        this.itemJpaRepository = itemJpaRepository;
    }

    @Override
    public void save(final ItemJpaEntity entity) {
        itemJpaRepository.save(entity);
    }

    @Override
    public ItemJpaEntity getById(final long itemId) {
        return itemJpaRepository.findById(itemId)
                .orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public long count() {
        return itemJpaRepository.count();
    }
}
