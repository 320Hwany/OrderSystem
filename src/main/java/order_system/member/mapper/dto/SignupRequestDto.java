package order_system.member.mapper.dto;

import lombok.Builder;

@Builder
public record SignupRequestDto(
        String username,
        String state,
        String city,
        String district
) {
}
