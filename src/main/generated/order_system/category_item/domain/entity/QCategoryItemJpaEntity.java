package order_system.category_item.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCategoryItemJpaEntity is a Querydsl query type for CategoryItemJpaEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCategoryItemJpaEntity extends EntityPathBase<CategoryItemJpaEntity> {

    private static final long serialVersionUID = 1380909316L;

    public static final QCategoryItemJpaEntity categoryItemJpaEntity = new QCategoryItemJpaEntity("categoryItemJpaEntity");

    public final order_system.global.QBaseEntity _super = new order_system.global.QBaseEntity(this);

    public final NumberPath<Long> categoryId = createNumber("categoryId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> itemId = createNumber("itemId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedAt = _super.lastModifiedAt;

    public QCategoryItemJpaEntity(String variable) {
        super(CategoryItemJpaEntity.class, forVariable(variable));
    }

    public QCategoryItemJpaEntity(Path<? extends CategoryItemJpaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCategoryItemJpaEntity(PathMetadata metadata) {
        super(CategoryItemJpaEntity.class, metadata);
    }

}

