package order_system.member.application.query;

import order_system.member.domain.Member;
import order_system.member.domain.entity.MemberJpaEntity;
import order_system.member.exception.MemberNotFoundException;
import order_system.member.exception.MemberNotMatchException;
import order_system.member.mapper.dto.LoginRequestDto;
import order_system.member.repository.MemberRepository;
import order_system.util.AcceptanceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.assertj.core.api.Assertions.*;

@AcceptanceTest
class QueryLoginServiceTest {

    @Autowired
    private QueryLoginService queryLoginService;

    @Autowired
    private MemberRepository memberRepository;

    private final MockHttpServletRequest request = new MockHttpServletRequest();

    @Test
    @DisplayName("회원 이름과 일치하는 회원이 없으면 예외가 발생합니다")
    void notFoundMember() {
        // given
        LoginRequestDto dto = LoginRequestDto.builder()
                .username("회원 이름")
                .password("1234")
                .build();

        // expected
        assertThatThrownBy(() -> queryLoginService.query(dto, request))
                .isInstanceOf(MemberNotFoundException.class);
    }

    @Test
    @DisplayName("회원 이름과 일치하는 회원이 있지만 비밀번호가 일치하지 않으면 예외가 발생합니다")
    void notMatchMember() {
        // given 1
        MemberJpaEntity entity = MemberJpaEntity.builder()
                .username("회원 이름")
                .password("1234")
                .build();

        memberRepository.save(entity);

        // given 2
        LoginRequestDto dto = LoginRequestDto.builder()
                .username("회원 이름")
                .password("일치하지 않는 비밀번호")
                .build();

        // expected
        assertThatThrownBy(() -> queryLoginService.query(dto, request))
                .isInstanceOf(MemberNotMatchException.class);
    }

    @Test
    @DisplayName("회원정보가 일치하면 세션을 생성하고 회원정보를 반환합니다")
    void loginSuccess() {
        // given 1
        MemberJpaEntity entity = MemberJpaEntity.builder()
                .username("회원 이름")
                .password("1234")
                .build();

        memberRepository.save(entity);

        // given 2
        LoginRequestDto dto = LoginRequestDto.builder()
                .username("회원 이름")
                .password("1234")
                .build();

        // when
        Member member = queryLoginService.query(dto, request);

        // then
        assertThat(member.username()).isEqualTo("회원 이름");
        assertThat(member.password()).isEqualTo("1234");
        assertThat(request.getSession(false)).isNotNull();
    }
}