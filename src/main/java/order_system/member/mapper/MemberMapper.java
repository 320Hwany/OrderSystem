package order_system.member.mapper;

import order_system.member.domain.Member;
import order_system.member.domain.MemberSession;
import order_system.member.domain.entity.MemberJpaEntity;
import order_system.member.mapper.dto.MemberResponseDto;
import order_system.member.mapper.dto.SignupRequestDto;

public class MemberMapper {

    public static Member toDomain(final MemberJpaEntity entity) {
        return Member.builder()
                .memberId(entity.getId())
                .password(entity.getPassword())
                .username(entity.getUsername())
                .state(entity.getState())
                .city(entity.getCity())
                .district(entity.getDistrict())
                .detailedAddress(entity.getDetailedAddress())
                .createdAt(entity.getCreatedAt())
                .lastModifiedAt(entity.getLastModifiedAt())
                .build();
    }

    public static MemberJpaEntity toEntity(final SignupRequestDto dto) {
        return MemberJpaEntity.builder()
                .username(dto.username())
                .state(dto.state())
                .city(dto.city())
                .district(dto.district())
                .detailedAddress(dto.detailedAddress())
                .build();
    }

    public static MemberResponseDto toResponseDto(final Member member) {
        return MemberResponseDto.builder()
                .memberId(member.memberId())
                .username(member.username())
                .state(member.state())
                .city(member.city())
                .district(member.district())
                .detailedAddress(member.detailedAddress())
                .build();
    }

    public static MemberSession toMemberSession(final Member member) {
        return MemberSession.builder()
                .memberId(member.memberId())
                .build();
    }
}
