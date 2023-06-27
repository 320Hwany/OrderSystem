package order_system.item.application.command;

import order_system.item.domain.Item;
import order_system.item.domain.entity.ItemJpaEntity;
import order_system.item.enumtype.BottomSize;
import order_system.item.enumtype.ShoeSize;
import order_system.item.enumtype.TopSize;
import order_system.item.exception.ItemNotFoundException;
import order_system.item.mapper.dto.ItemUpdateRequestDto;
import order_system.item.repository.ItemRepository;
import order_system.util.AcceptanceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;

@AcceptanceTest
class CommandItemUpdateServiceTest {

    @Autowired
    private CommandItemUpdateService commandItemUpdateService;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    @DisplayName("상품 id에 맞는 상품이 없다면 예외가 발생합니다")
    void notFoundItem() {
        // given
        ItemUpdateRequestDto dto = ItemUpdateRequestDto.builder()
                .itemId(1)
                .itemName("수정 상품명")
                .itemPrice(100000)
                .shoeSize(ShoeSize.SIZE_270)
                .topSize(TopSize.XL)
                .bottomSize(BottomSize.SIZE_32)
                .build();

        // expected
        assertThatThrownBy(() -> commandItemUpdateService.command(dto))
                .isInstanceOf(ItemNotFoundException.class);
    }


    @Test
    @DisplayName("상품 id에 맞는 상품이 있다면 수정합니다")
    void commandItemUpdateService() {
        // given
        ItemJpaEntity entity = saveItem();

        ItemUpdateRequestDto dto = ItemUpdateRequestDto.builder()
                .itemId(entity.getId())
                .itemName("수정 상품명")
                .itemPrice(100000)
                .shoeSize(ShoeSize.SIZE_270)
                .topSize(TopSize.XL)
                .bottomSize(BottomSize.SIZE_32)
                .build();

        // when
        Item item = commandItemUpdateService.command(dto);

        // then
        assertThat(item.itemId()).isEqualTo(entity.getId());
        assertThat(item.itemName()).isEqualTo("수정 상품명");
        assertThat(item.itemPrice()).isEqualTo(100000);
        assertThat(item.shoeSize()).isEqualTo(ShoeSize.SIZE_270);
        assertThat(item.topSize()).isEqualTo(TopSize.XL);
        assertThat(item.bottomSize()).isEqualTo(BottomSize.SIZE_32);
    }

    protected ItemJpaEntity saveItem() {
        ItemJpaEntity entity = ItemJpaEntity.builder()
                .itemName("상품 이름")
                .itemPrice(50000)
                .stockQuantity(3000)
                .shoeSize(ShoeSize.SIZE_260)
                .topSize(TopSize.L)
                .bottomSize(BottomSize.SIZE_30)
                .build();

        itemRepository.save(entity);
        return entity;
    }
}