package order_system.member.application.command;

import order_system.member.mapper.dto.SignupRequestDto;
import order_system.member.repository.MemberRepository;
import order_system.util.AcceptanceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@AcceptanceTest
class CommandSignupServiceTest {

    @Autowired
    private CommandSignupService commandSignupService;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("회원가입에 성공하면 DB에 회원이 저장됩니다")
    void commandSignupService() {
        // given
        SignupRequestDto dto = SignupRequestDto.builder()
                .username("회원 이름")
                .password("1234")
                .state("경기도")
                .city("수원시")
                .district("영통구")
                .detailedAddress("상세 주소")
                .build();

        // when
        commandSignupService.command(dto);

        // then
        assertThat(memberRepository.count()).isEqualTo(1);
    }
}