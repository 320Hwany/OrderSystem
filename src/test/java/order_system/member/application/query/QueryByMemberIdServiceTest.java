package order_system.member.application.query;

import order_system.member.domain.Member;
import order_system.member.domain.entity.MemberJpaEntity;
import order_system.member.exception.MemberNotFoundException;
import order_system.member.repository.MemberRepository;
import order_system.util.AcceptanceTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;

@AcceptanceTest
class QueryByMemberIdServiceTest {

    @Autowired
    private QueryByMemberIdService queryByMemberIdService;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("회원 id와 일치하는 회원이 없으면 예외가 발생합니다")
    void notFoundMember() {
        // expected
        assertThatThrownBy(() -> queryByMemberIdService.query(1L))
                .isInstanceOf(MemberNotFoundException.class);
    }

    @Test
    @DisplayName("회원 id와 일치하는 회원을 찾아 반환합니다")
    void findMember() {
        // given
        MemberJpaEntity entity = MemberJpaEntity.builder()
                .username("회원 이름")
                .password("1234")
                .build();

        memberRepository.save(entity);

        // when
        Member member = queryByMemberIdService.query(entity.getId());

        // then
        assertThat(member.username()).isEqualTo("회원 이름");
        assertThat(member.password()).isEqualTo("1234");
    }
}