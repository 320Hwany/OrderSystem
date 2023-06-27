package order_system.order_item.repository;

import order_system.order_item.domain.entity.OrderItemJpaEntity;
import org.springframework.stereotype.Repository;

@Repository
public class OrderItemRepositoryImpl implements OrderItemRepository {

    private final OrderItemJpaRepository orderItemJpaRepository;

    public OrderItemRepositoryImpl(final OrderItemJpaRepository orderItemJpaRepository) {
        this.orderItemJpaRepository = orderItemJpaRepository;
    }

    @Override
    public void save(OrderItemJpaEntity entity) {
        orderItemJpaRepository.save(entity);
    }

    @Override
    public long count() {
        return orderItemJpaRepository.count();
    }
}
