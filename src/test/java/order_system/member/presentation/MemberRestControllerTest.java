package order_system.member.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import order_system.member.domain.entity.MemberJpaEntity;
import order_system.member.mapper.dto.LoginRequestDto;
import order_system.member.mapper.dto.SignupRequestDto;
import order_system.member.repository.MemberRepository;
import order_system.util.AcceptanceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@AcceptanceTest
class MemberRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MemberRepository memberRepository;

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
        mockMvc.perform(post("/api/signup")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("올바른 정보를 입력하면 회원가입에 성공합니다")
    void signupSuccess() throws Exception {
        // given
        SignupRequestDto dto = SignupRequestDto.builder()
                .username("회원 이름")
                .password("1234")
                .state("경기도")
                .city("수원시")
                .district("영통구")
                .detailedAddress("상세 주소")
                .build();

        // expected
        mockMvc.perform(post("/api/signup")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("로그인시 비밀번호를 입력하지 않으면 예외가 발생합니다")
    void memberValid() throws Exception {
        // given
        LoginRequestDto dto = LoginRequestDto.builder()
                .username("회원 이름")
                .build();

        // expected
        mockMvc.perform(post("/api/login")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("회원이름과 비밀번호가 일치하면 로그인에 성공합니다")
    void loginSuccess() throws Exception {
        // given
        signup();

        LoginRequestDto dto = LoginRequestDto.builder()
                .username("회원 이름")
                .password("1234")
                .build();

        // expected
        mockMvc.perform(post("/api/login")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("로그인하지 않으면 정보를 가져올 수 없습니다")
    void unauthorizedMember() throws Exception {
        // expected
        mockMvc.perform(get("/api/member"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("로그인한 회원의 정보를 가져옵니다")
    void getSuccess() throws Exception {
        // given
        signup();
        MockHttpSession session = loginMemberSession();

        // expected
        mockMvc.perform(get("/api/member")
                        .session(session))
                .andExpect(status().isOk());
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