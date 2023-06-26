package order_system.member.application.query;

import order_system.member.domain.Member;
import order_system.member.domain.entity.MemberJpaEntity;
import order_system.member.mapper.MemberMapper;
import order_system.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class QueryByMemberIdService {

    private final MemberRepository memberRepository;

    public QueryByMemberIdService(final MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member query(final long memberId) {
        MemberJpaEntity entity = memberRepository.getById(memberId);
        return MemberMapper.toDomain(entity);
    }
}
