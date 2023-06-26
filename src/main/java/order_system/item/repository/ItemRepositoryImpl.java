package order_system.item.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    private final ItemJpaRepository itemJpaRepository;

    public ItemRepositoryImpl(final ItemJpaRepository itemJpaRepository) {
        this.itemJpaRepository = itemJpaRepository;
    }
}