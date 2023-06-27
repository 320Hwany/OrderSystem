package order_system.order_item.application.query;

import order_system.order_item.mapper.dto.OrderItemForMemberDto;
import order_system.order_item.repository.OrderItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class QueryOrderItemByMemberIdService {

    private final OrderItemRepository orderItemRepository;

    public QueryOrderItemByMemberIdService(final OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItemForMemberDto> query(final long memberId) {
        return orderItemRepository.findByMemberId(memberId);
    }
}
