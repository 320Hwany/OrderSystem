package order_system.member.repository;

import order_system.member.domain.entity.MemberJpaEntity;

public interface MemberRepository {

    void save(final MemberJpaEntity entity);

    MemberJpaEntity getById(final long memberId);

    long count();
}
