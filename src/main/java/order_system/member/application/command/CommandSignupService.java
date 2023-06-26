package order_system.member.application.command;

import order_system.member.domain.entity.MemberJpaEntity;
import order_system.member.mapper.MemberMapper;
import order_system.member.mapper.dto.SignupRequestDto;
import order_system.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CommandSignupService {

    private final MemberRepository memberRepository;

    public CommandSignupService(final MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void command(final SignupRequestDto dto) {
        MemberJpaEntity entity = MemberMapper.toEntity(dto);
        memberRepository.save(entity);
    }
}
