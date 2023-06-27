package order_system.item.application.query;

import order_system.item.domain.Item;
import order_system.item.domain.entity.ItemJpaEntity;
import order_system.item.enumtype.BottomSize;
import order_system.item.enumtype.CategoryType;
import order_system.item.enumtype.ShoeSize;
import order_system.item.enumtype.TopSize;
import order_system.item.exception.ItemNotFoundException;
import order_system.item.repository.ItemRepository;
import order_system.util.AcceptanceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;

@AcceptanceTest
class QueryItemByIdServiceTest {

    @Autowired
    private QueryItemByIdService queryItemByIdService;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    @DisplayName("상품 id와 일치하는 상품이 없으면 예외가 발생합니다")
    void getFail() {
        // expected
        assertThatThrownBy(() -> queryItemByIdService.query(1L))
                .isInstanceOf(ItemNotFoundException.class);
    }

    @Test
    @DisplayName("상품 id와 일치하는 상품이 있다면 상품을 조회합니다")
    void getSuccess() {
        // given
        ItemJpaEntity entity = saveItem();

        // when
        Item item = queryItemByIdService.query(entity.getId());

        // then
        assertThat(item.itemId()).isEqualTo(entity.getId());
        assertThat(item.itemName()).isEqualTo(entity.getItemName());
        assertThat(item.itemPrice()).isEqualTo(entity.getItemPrice());
        assertThat(item.stockQuantity()).isEqualTo(entity.getStockQuantity());
        assertThat(item.shoeSize()).isEqualTo(entity.getShoeSize());
        assertThat(item.topSize()).isEqualTo(entity.getTopSize());
        assertThat(item.bottomSize()).isEqualTo(entity.getBottomSize());
        assertThat(item.categoryType()).isEqualTo(entity.getCategoryType());
        assertThat(item.createdAt()).isEqualTo(entity.getCreatedAt());
        assertThat(item.lastModifiedAt()).isEqualTo(entity.getLastModifiedAt());
    }


    protected ItemJpaEntity saveItem() {
        ItemJpaEntity entity = ItemJpaEntity.builder()
                .itemName("상품 이름")
                .itemPrice(50000)
                .stockQuantity(3000)
                .shoeSize(ShoeSize.SIZE_260)
                .topSize(TopSize.L)
                .bottomSize(BottomSize.SIZE_30)
                .categoryType(CategoryType.SHOES)
                .build();

        itemRepository.save(entity);
        return entity;
    }
}