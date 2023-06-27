package order_system.order_item.application.command;

import order_system.delivery.DeliveryStatus;
import order_system.delivery.domain.entity.DeliveryJpaEntity;
import order_system.delivery.repository.DeliveryRepository;
import order_system.order.OrderStatus;
import order_system.order.domain.entity.OrderJpaEntity;
import order_system.order.repository.OrderRepository;
import order_system.order_item.repository.OrderItemRepository;
import order_system.util.AcceptanceTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@AcceptanceTest
class CommandOrderItemCancelServiceTest {

    @Autowired
    private CommandOrderItemCancelService commandOrderItemCancelService;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Test
    @DisplayName("주문을 취소하면 주문/상품 연결테이블 정보가 삭제됩니다")
    void commandOrderItemCancelService() {
        // given 1
        DeliveryJpaEntity deliveryJpaEntity = DeliveryJpaEntity.builder()
                .deliveryStatus(DeliveryStatus.DELIVERY)
                .build();

        deliveryRepository.save(deliveryJpaEntity);

        // given 2
        OrderJpaEntity orderJpaEntity = OrderJpaEntity.builder()
                .memberId(1)
                .deliveryId(deliveryJpaEntity.getId())
                .orderStatus(OrderStatus.COMPLETE)
                .build();

        orderRepository.save(orderJpaEntity);

        // when
        commandOrderItemCancelService.command(orderJpaEntity.getId());

        // then
        assertThat(orderItemRepository.count()).isEqualTo(0);
        assertThat(orderRepository.count()).isEqualTo(0);
        assertThat(deliveryRepository.count()).isEqualTo(0);
    }
}