package order_system.order_item.repository;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import order_system.order.domain.entity.QOrderJpaEntity;
import order_system.order_item.domain.entity.OrderItemJpaEntity;
import order_system.order_item.domain.entity.QOrderItemJpaEntity;
import order_system.order_item.mapper.dto.OrderItemForMemberDto;
import order_system.order_item.mapper.dto.QOrderItemForMemberDto;
import org.springframework.stereotype.Repository;

import java.util.List;

import static order_system.order.domain.entity.QOrderJpaEntity.*;
import static order_system.order_item.domain.entity.QOrderItemJpaEntity.*;

@Repository
public class OrderItemRepositoryImpl implements OrderItemRepository {

    private final OrderItemJpaRepository orderItemJpaRepository;
    private final JPAQueryFactory queryFactory;

    public OrderItemRepositoryImpl(final OrderItemJpaRepository orderItemJpaRepository,
                                   final JPAQueryFactory queryFactory) {
        this.orderItemJpaRepository = orderItemJpaRepository;
        this.queryFactory = queryFactory;
    }

    @Override
    public void save(OrderItemJpaEntity entity) {
        orderItemJpaRepository.save(entity);
    }

    @Override
    public List<OrderItemForMemberDto> findByMemberId(final long memberId) {
        return queryFactory.select(new QOrderItemForMemberDto(
                        Expressions.asNumber(memberId).as("memberId"),
                        orderItemJpaEntity.orderId,
                        orderItemJpaEntity.itemId,
                        orderJpaEntity.orderStatus,
                        orderItemJpaEntity.orderPrice,
                        orderItemJpaEntity.orderQuantity
                ))
                .from(orderItemJpaEntity)
                .innerJoin(orderJpaEntity).on(orderJpaEntity.memberId.eq(memberId))
                .fetch();
    }

    @Override
    public void deleteAllByOrderId(final long orderId) {
        orderItemJpaRepository.deleteAllByOrderId(orderId);
    }

    @Override
    public long count() {
        return orderItemJpaRepository.count();
    }
}
