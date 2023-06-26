package order_system.order.repository;

import org.springframework.stereotype.Repository;

@Repository
public class OrderJpaRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;

    public OrderJpaRepositoryImpl(final OrderJpaRepository orderJpaRepository) {
        this.orderJpaRepository = orderJpaRepository;
    }
}
