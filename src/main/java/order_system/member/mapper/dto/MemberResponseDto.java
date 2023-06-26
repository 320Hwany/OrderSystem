package order_system.member.mapper.dto;

import lombok.Builder;

@Builder
public record MemberResponseDto(
        long memberId,
        String username,
        String state,
        String city,
        String district,
        String detailedAddress
) {
}
