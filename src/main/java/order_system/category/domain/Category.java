package order_system.category.domain;

import lombok.Builder;
import order_system.category.CategoryType;

import java.time.LocalDateTime;

@Builder
public record Category(
        long categoryId,
        CategoryType categoryType,
        LocalDateTime createdAt,
        LocalDateTime lastModifiedAt
) {
}
