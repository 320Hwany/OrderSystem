package order_system.member.mapper.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record LoginRequestDto(
        @NotBlank
        String username,
        @NotBlank
        String password
) {
}
