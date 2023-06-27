package order_system.order_item.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import order_system.delivery.DeliveryStatus;
import order_system.delivery.domain.entity.DeliveryJpaEntity;
import order_system.delivery.repository.DeliveryRepository;
import order_system.member.domain.entity.MemberJpaEntity;
import order_system.member.mapper.dto.LoginRequestDto;
import order_system.member.repository.MemberRepository;
import order_system.order.OrderStatus;
import order_system.order.domain.entity.OrderJpaEntity;
import order_system.order.repository.OrderRepository;
import order_system.order_item.mapper.dto.OrderItemSaveRequestDto;
import order_system.util.AcceptanceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@AcceptanceTest
class OrderItemRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Test
    @DisplayName("로그인을 하지 않으면 예외가 발생합니다")
    void unauthorized() throws Exception {
        // given
        OrderItemSaveRequestDto dto = OrderItemSaveRequestDto.builder()
                .itemId(1)
                .orderPrice(50000)
                .orderQuantity(3)
                .build();

        // expected
        mockMvc.perform(post("/api/orderItem")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("로그인을 한 후 주문을 할 수 있습니다")
    void saveOrderItem() throws Exception {
        // given
        OrderItemSaveRequestDto dto = OrderItemSaveRequestDto.builder()
                .itemId(1)
                .orderPrice(50000)
                .orderQuantity(3)
                .build();

        signup();
        MockHttpSession session = loginMemberSession();

        // expected
        mockMvc.perform(post("/api/orderItem")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto))
                        .session(session))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("로그인을 하지 않으면 주문을 취소할 수 없습니다")
    void cancelOrderItemUnauthorized() throws Exception {
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

        // expected
        mockMvc.perform(delete("/api/orderItem/{orderId}", orderJpaEntity.getId()))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("주문 id에 맞는 주문을 취소합니다")
    void cancelOrderItem() throws Exception {
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

        // given3
        signup();
        MockHttpSession session = loginMemberSession();

        // expected
        mockMvc.perform(delete("/api/orderItem/{orderId}", orderJpaEntity.getId())
                        .session(session))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("주문 id에 해당하는 주문이 없으면 예외가 발생합니다")
    void cancelOrderItemNotFound() throws Exception {
        // given
        signup();
        MockHttpSession session = loginMemberSession();

        // when
        mockMvc.perform(delete("/api/orderItem/{orderId}", 1)
                        .session(session))
                .andExpect(status().isNotFound());
    }

    protected void signup() {
        MemberJpaEntity entity = MemberJpaEntity.builder()
                .username("회원 이름")
                .password("1234")
                .build();

        memberRepository.save(entity);
    }

    protected MockHttpSession loginMemberSession() throws Exception {
        LoginRequestDto dto = LoginRequestDto.builder()
                .username("회원 이름")
                .password("1234")
                .build();

        MockHttpServletRequest request = mockMvc.perform(post("/api/login")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andReturn().getRequest();

        HttpSession session = request.getSession();
        return (MockHttpSession)session;
    }
}