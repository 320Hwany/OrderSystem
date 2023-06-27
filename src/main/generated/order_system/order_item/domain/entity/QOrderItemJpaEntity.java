package order_system.order_item.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QOrderItemJpaEntity is a Querydsl query type for OrderItemJpaEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrderItemJpaEntity extends EntityPathBase<OrderItemJpaEntity> {

    private static final long serialVersionUID = -1702416614L;

    public static final QOrderItemJpaEntity orderItemJpaEntity = new QOrderItemJpaEntity("orderItemJpaEntity");

    public final order_system.global.QBaseEntity _super = new order_system.global.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> itemId = createNumber("itemId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedAt = _super.lastModifiedAt;

    public final NumberPath<Long> orderId = createNumber("orderId", Long.class);

    public final NumberPath<Long> orderPrice = createNumber("orderPrice", Long.class);

    public final NumberPath<Long> orderQuantity = createNumber("orderQuantity", Long.class);

    public QOrderItemJpaEntity(String variable) {
        super(OrderItemJpaEntity.class, forVariable(variable));
    }

    public QOrderItemJpaEntity(Path<? extends OrderItemJpaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrderItemJpaEntity(PathMetadata metadata) {
        super(OrderItemJpaEntity.class, metadata);
    }

}

