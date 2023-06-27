package order_system.order.repository;

import order_system.order.domain.entity.OrderJpaEntity;
import order_system.order.exception.OrderNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;

    public OrderRepositoryImpl(final OrderJpaRepository orderJpaRepository) {
        this.orderJpaRepository = orderJpaRepository;
    }

    @Override
    public void save(final OrderJpaEntity entity) {
        orderJpaRepository.save(entity);
    }

    @Override
    public OrderJpaEntity getById(long orderId) {
        return orderJpaRepository.findById(orderId)
                .orElseThrow(OrderNotFoundException::new);
    }

    @Override
    public long count() {
        return orderJpaRepository.count();
    }
}
