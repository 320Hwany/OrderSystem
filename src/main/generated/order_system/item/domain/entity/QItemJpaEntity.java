package order_system.item.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QItemJpaEntity is a Querydsl query type for ItemJpaEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QItemJpaEntity extends EntityPathBase<ItemJpaEntity> {

    private static final long serialVersionUID = 2028934493L;

    public static final QItemJpaEntity itemJpaEntity = new QItemJpaEntity("itemJpaEntity");

    public final order_system.global.QBaseEntity _super = new order_system.global.QBaseEntity(this);

    public final EnumPath<order_system.item.enumtype.BottomSize> bottomSize = createEnum("bottomSize", order_system.item.enumtype.BottomSize.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath itemName = createString("itemName");

    public final NumberPath<Long> itemPrice = createNumber("itemPrice", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedAt = _super.lastModifiedAt;

    public final EnumPath<order_system.item.enumtype.ShoeSize> shoeSize = createEnum("shoeSize", order_system.item.enumtype.ShoeSize.class);

    public final NumberPath<Long> stockQuantity = createNumber("stockQuantity", Long.class);

    public final EnumPath<order_system.item.enumtype.TopSize> topSize = createEnum("topSize", order_system.item.enumtype.TopSize.class);

    public QItemJpaEntity(String variable) {
        super(ItemJpaEntity.class, forVariable(variable));
    }

    public QItemJpaEntity(Path<? extends ItemJpaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QItemJpaEntity(PathMetadata metadata) {
        super(ItemJpaEntity.class, metadata);
    }

}

