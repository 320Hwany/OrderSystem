package order_system.member.repository;

import order_system.member.entity.MemberJpaEntity;

public interface MemberRepository {

    MemberJpaEntity getById(final long memberId);
}
