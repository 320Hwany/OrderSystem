package order_system.order_item.repository;

import order_system.order_item.domain.entity.OrderItemJpaEntity;
import order_system.order_item.mapper.dto.OrderItemForMemberDto;

import java.util.List;

public interface OrderItemRepository {

    void save(final OrderItemJpaEntity entity);

    List<OrderItemForMemberDto> findByMemberId(final long memberId);

    void deleteAllByOrderId(final long orderId);

    long count();
}
