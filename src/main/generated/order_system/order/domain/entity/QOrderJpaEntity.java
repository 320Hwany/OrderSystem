package order_system.order.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QOrderJpaEntity is a Querydsl query type for OrderJpaEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrderJpaEntity extends EntityPathBase<OrderJpaEntity> {

    private static final long serialVersionUID = -111843617L;

    public static final QOrderJpaEntity orderJpaEntity = new QOrderJpaEntity("orderJpaEntity");

    public final order_system.global.QBaseEntity _super = new order_system.global.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> deliveryId = createNumber("deliveryId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedAt = _super.lastModifiedAt;

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final EnumPath<order_system.order.OrderStatus> orderStatus = createEnum("orderStatus", order_system.order.OrderStatus.class);

    public QOrderJpaEntity(String variable) {
        super(OrderJpaEntity.class, forVariable(variable));
    }

    public QOrderJpaEntity(Path<? extends OrderJpaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrderJpaEntity(PathMetadata metadata) {
        super(OrderJpaEntity.class, metadata);
    }

}

