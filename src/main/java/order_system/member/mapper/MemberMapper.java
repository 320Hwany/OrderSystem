package order_system.member.mapper;

import order_system.member.domain.entity.MemberJpaEntity;
import order_system.member.mapper.dto.SignupRequestDto;

public class MemberMapper {

    public static MemberJpaEntity toEntity(final SignupRequestDto dto) {
        return MemberJpaEntity.builder()
                .username(dto.username())
                .state(dto.state())
                .city(dto.city())
                .district(dto.district())
                .detailedAddress(dto.detailedAddress())
                .build();
    }
}
