package order_system.order.application.command;

import order_system.delivery.DeliveryStatus;
import order_system.delivery.domain.entity.DeliveryJpaEntity;
import order_system.delivery.repository.DeliveryRepository;
import order_system.order.OrderStatus;
import order_system.order.domain.entity.OrderJpaEntity;
import order_system.order.exception.OrderNotFoundException;
import order_system.order.repository.OrderRepository;
import order_system.util.AcceptanceTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@AcceptanceTest
class CommandOrderCancelServiceTest {

    @Autowired
    private CommandOrderCancelService commandOrderCancelService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Test
    @DisplayName("주문 id에 해당하는 주문이 없다면 예외가 발생합니다")
    void commandOrderCancelServiceFail() {
        // when
        assertThatThrownBy(() -> commandOrderCancelService.command(1))
                .isInstanceOf(OrderNotFoundException.class);
    }

    @Test
    @DisplayName("주문을 취소하면 주문 취소와 함께 해당 배송 정보도 삭제됩니다")
    void commandOrderCancelService() {
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
        commandOrderCancelService.command(orderJpaEntity.getId());

        // then
        assertThat(deliveryRepository.count()).isEqualTo(0);
        assertThat(orderRepository.count()).isEqualTo(0);
    }
}