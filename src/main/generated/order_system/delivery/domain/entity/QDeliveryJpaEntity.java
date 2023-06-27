package order_system.delivery.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QDeliveryJpaEntity is a Querydsl query type for DeliveryJpaEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDeliveryJpaEntity extends EntityPathBase<DeliveryJpaEntity> {

    private static final long serialVersionUID = 1303740029L;

    public static final QDeliveryJpaEntity deliveryJpaEntity = new QDeliveryJpaEntity("deliveryJpaEntity");

    public final order_system.global.QBaseEntity _super = new order_system.global.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final EnumPath<order_system.delivery.DeliveryStatus> deliveryStatus = createEnum("deliveryStatus", order_system.delivery.DeliveryStatus.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedAt = _super.lastModifiedAt;

    public QDeliveryJpaEntity(String variable) {
        super(DeliveryJpaEntity.class, forVariable(variable));
    }

    public QDeliveryJpaEntity(Path<? extends DeliveryJpaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDeliveryJpaEntity(PathMetadata metadata) {
        super(DeliveryJpaEntity.class, metadata);
    }

}

