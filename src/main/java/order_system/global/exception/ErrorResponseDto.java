package order_system.global.exception;

import lombok.Builder;

@Builder
public record ErrorResponseDto(
        String statusCode,
        String message
) {
}
