package order_system.member.repository;

import order_system.member.domain.entity.MemberJpaEntity;
import order_system.member.exception.MemberNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberJpaRepository memberJpaRepository;

    public MemberRepositoryImpl(final MemberJpaRepository memberJpaRepository) {
        this.memberJpaRepository = memberJpaRepository;
    }

    @Override
    public void save(final MemberJpaEntity entity) {
        memberJpaRepository.save(entity);
    }

    @Override
    public MemberJpaEntity getById(final long memberId) {
        return memberJpaRepository.findById(memberId)
                .orElseThrow(MemberNotFoundException::new);
    }

    @Override
    public Optional<MemberJpaEntity> findByUsername(final String username) {
        return memberJpaRepository.findByUsername(username);
    }

    @Override
    public long count() {
        return memberJpaRepository.count();
    }
}
