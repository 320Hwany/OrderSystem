package order_system.order_item.application.query;

import order_system.member.domain.entity.MemberJpaEntity;
import order_system.member.repository.MemberRepository;
import order_system.order.OrderStatus;
import order_system.order.domain.entity.OrderJpaEntity;
import order_system.order.repository.OrderRepository;
import order_system.order_item.domain.entity.OrderItemJpaEntity;
import order_system.order_item.mapper.dto.OrderItemForMemberDto;
import order_system.order_item.repository.OrderItemRepository;
import order_system.util.AcceptanceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


@AcceptanceTest
class QueryOrderItemByMemberIdServiceTest {

    @Autowired
    private QueryOrderItemByMemberIdService queryOrderItemByMemberIdService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Test
    @DisplayName("상품/주문 연결 테이블에서 로그인 한 회원의 주문 정보를 가져옵니다")
    void test() {
        // given 1
        MemberJpaEntity memberJpaEntity = MemberJpaEntity.builder()
                .username("회원 이름")
                .password("1234")
                .build();

        memberRepository.save(memberJpaEntity);

        // given 2
        OrderJpaEntity orderJpaEntity = OrderJpaEntity.builder()
                .memberId(memberJpaEntity.getId())
                .orderStatus(OrderStatus.IN_BASKET)
                .build();

        orderRepository.save(orderJpaEntity);

        // given 3
        OrderItemJpaEntity orderItemJpaEntity = OrderItemJpaEntity.builder()
                .orderId(orderJpaEntity.getId())
                .itemId(1)
                .orderPrice(50000)
                .orderQuantity(30)
                .build();

        orderItemRepository.save(orderItemJpaEntity);

        // when
        List<OrderItemForMemberDto> dtos = queryOrderItemByMemberIdService.query(memberJpaEntity.getId());

        // then
        assertThat(dtos.size()).isEqualTo(1);
        assertThat(dtos.get(0).memberId()).isEqualTo(memberJpaEntity.getId());
        assertThat(dtos.get(0).orderId()).isEqualTo(orderJpaEntity.getId());
        assertThat(dtos.get(0).itemId()).isEqualTo(1);
        assertThat(dtos.get(0).orderStatus()).isEqualTo(OrderStatus.IN_BASKET);
        assertThat(dtos.get(0).orderPrice()).isEqualTo(50000);
        assertThat(dtos.get(0).orderQuantity()).isEqualTo(30);
    }
}