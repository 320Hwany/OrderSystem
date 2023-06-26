package order_system.member.domain;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record Member(
        long memberId,
        String username,
        String state,
        String city,
        String district,
        String detailedAddress,
        LocalDateTime createdAt,
        LocalDateTime lastModifiedAt
) {
}
