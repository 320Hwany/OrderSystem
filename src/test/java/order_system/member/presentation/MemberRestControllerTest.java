package order_system.member.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import order_system.member.mapper.dto.SignupRequestDto;
import order_system.util.AcceptanceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@AcceptanceTest
class MemberRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("회원가입시 회원이름을 입력하지 않으면 예외가 발생합니다")
    void signupFail() throws Exception {
        // given
        SignupRequestDto dto = SignupRequestDto.builder()
                .state("경기도")
                .city("수원시")
                .district("영통구")
                .detailedAddress("상세 주소")
                .build();

        // expected
        mockMvc.perform(MockMvcRequestBuilders.post("/api/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("올바른 정보를 입력하면 회원가입에 성공합니다")
    void signupSuccess() throws Exception {
        // given
        SignupRequestDto dto = SignupRequestDto.builder()
                .username("회원 이름")
                .state("경기도")
                .city("수원시")
                .district("영통구")
                .detailedAddress("상세 주소")
                .build();

        // expected
        mockMvc.perform(MockMvcRequestBuilders.post("/api/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());
    }
}