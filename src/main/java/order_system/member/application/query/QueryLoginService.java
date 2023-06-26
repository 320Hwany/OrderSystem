package order_system.member.application.query;

import jakarta.servlet.http.HttpServletRequest;
import order_system.member.domain.Member;
import order_system.member.domain.MemberSession;
import order_system.member.domain.entity.MemberJpaEntity;
import order_system.member.exception.MemberNotFoundException;
import order_system.member.exception.MemberNotMatchException;
import order_system.member.mapper.MemberMapper;
import order_system.member.mapper.dto.LoginRequestDto;
import order_system.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
@Service
public class QueryLoginService {

    private final MemberRepository memberRepository;

    public QueryLoginService(final MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member query(final LoginRequestDto dto, final HttpServletRequest request) {
        Optional<MemberJpaEntity> entityOptional = memberRepository.findByUsername(dto.username());
        if (entityOptional.isPresent()) {
            MemberJpaEntity entity = entityOptional.get();
            Member member = MemberMapper.toDomain(entity);

            if (member.password().equals(dto.password())) {
                makeSession(member, request);
                return member;
            }
            throw new MemberNotMatchException();
        }
        throw new MemberNotFoundException();
    }

    protected void makeSession(final Member member, final HttpServletRequest request) {
        MemberSession memberSession = MemberMapper.toMemberSession(member);
        memberSession.makeSession(request);
    }
}
