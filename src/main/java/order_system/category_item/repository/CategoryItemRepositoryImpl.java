package order_system.category_item.repository;

import org.springframework.stereotype.Repository;

@Repository
public class CategoryItemRepositoryImpl implements CategoryItemRepository {

    private final CategoryItemJpaRepository categoryItemJpaRepository;

    public CategoryItemRepositoryImpl(final CategoryItemJpaRepository categoryItemJpaRepository) {
        this.categoryItemJpaRepository = categoryItemJpaRepository;
    }
}
