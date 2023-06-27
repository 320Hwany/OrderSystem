package order_system.order_item.application.command;

import order_system.delivery.repository.DeliveryRepository;
import order_system.order.repository.OrderRepository;
import order_system.order_item.domain.OrderItem;
import order_system.order_item.mapper.dto.OrderItemSaveRequestDto;
import order_system.order_item.repository.OrderItemRepository;
import order_system.util.AcceptanceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@AcceptanceTest
class CommandOrderItemSaveServiceTest {

    @Autowired
    private CommandOrderItemSaveService commandOrderItemSaveService;

    @Autowired
    private OrderItemRepository orderItemRepository;


    @Test
    @DisplayName("회원 id와 주문 정보를 바탕으로 상품/주문 연결 테이블을 DB에 저장합니다")
    void commandOrderItemSaveService() {
        // given
        OrderItemSaveRequestDto dto = OrderItemSaveRequestDto.builder()
                .itemId(1)
                .orderPrice(50000)
                .orderQuantity(5)
                .build();

        // when
        OrderItem orderItem = commandOrderItemSaveService.command(1, dto);

        // then
        assertThat(orderItemRepository.count()).isEqualTo(1);
        assertThat(orderItem.itemId()).isEqualTo(1);
        assertThat(orderItem.orderPrice()).isEqualTo(50000);
        assertThat(orderItem.orderQuantity()).isEqualTo(5);
    }
}