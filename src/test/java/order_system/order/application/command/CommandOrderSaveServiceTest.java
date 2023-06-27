package order_system.order.application.command;

import order_system.delivery.DeliveryStatus;
import order_system.delivery.domain.entity.DeliveryJpaEntity;
import order_system.delivery.repository.DeliveryRepository;
import order_system.order.OrderStatus;
import order_system.order.domain.Order;
import order_system.order.domain.entity.OrderJpaEntity;
import order_system.order.repository.OrderRepository;
import order_system.util.AcceptanceTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;


@AcceptanceTest
class CommandOrderSaveServiceTest {

    @Autowired
    private CommandOrderSaveService commandOrderSaveService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Test
    @DisplayName("주문을 하면 배송중/결제완료 상황이 되며 DB에 정보가 저장됩니다")
    void commandOrderSaveService() {
        // when
        Order order = commandOrderSaveService.command(1);

        DeliveryJpaEntity deliveryJpaEntity = deliveryRepository.getById(order.deliveryId());
        OrderJpaEntity orderJpaEntity = orderRepository.getById(order.orderId());

        // then
        assertThat(deliveryRepository.count()).isEqualTo(1);
        assertThat(orderRepository.count()).isEqualTo(1);
        assertThat(deliveryJpaEntity.getDeliveryStatus()).isEqualTo(DeliveryStatus.DELIVERY);
        assertThat(orderJpaEntity.getOrderStatus()).isEqualTo(OrderStatus.COMPLETE);
    }
}