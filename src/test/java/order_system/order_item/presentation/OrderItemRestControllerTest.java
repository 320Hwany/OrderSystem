package order_system.order_item.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import order_system.member.domain.entity.MemberJpaEntity;
import order_system.member.mapper.dto.LoginRequestDto;
import order_system.member.repository.MemberRepository;
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

    @Test
    @DisplayName("로그인을 하지 않으면 예외가 발생합니다")
    void unauthorized() throws Exception {
        // given
        OrderItemSaveRequestDto dto = OrderItemSaveRequestDto.builder()
                .itemId(1)
                .orderPrice(50000)
                .orderQuantity(3)
                .build();

        // when
        mockMvc.perform(MockMvcRequestBuilders.post("/api/orderItem")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isUnauthorized());

        // then
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

        // when
        mockMvc.perform(MockMvcRequestBuilders.post("/api/orderItem")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto))
                        .session(session))
                .andExpect(status().isOk());

        // then
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