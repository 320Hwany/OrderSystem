package order_system.member.mapper.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record SignupRequestDto(
        @NotBlank
        String username,
        String state,
        String city,
        String district,
        String detailedAddress
) {
}
