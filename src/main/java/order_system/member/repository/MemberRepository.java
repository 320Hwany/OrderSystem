package order_system.member.repository;

import order_system.member.domain.entity.MemberJpaEntity;

import java.util.Optional;

public interface MemberRepository {

    void save(final MemberJpaEntity entity);

    MemberJpaEntity getById(final long memberId);

    Optional<MemberJpaEntity> findByUsername(final String username);

    long count();
}
