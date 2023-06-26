package order_system.category_item.domain;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record CategoryItem(
        long categoryItemId,
        long itemId,
        long categoryId,
        LocalDateTime createdAt,
        LocalDateTime lastModifiedAt
) {
}
