package order_system.item.application.command;

import order_system.item.enumtype.BottomSize;
import order_system.item.enumtype.ShoeSize;
import order_system.item.enumtype.TopSize;
import order_system.item.mapper.dto.ItemSaveRequestDto;
import order_system.item.repository.ItemRepository;
import order_system.util.AcceptanceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;

@AcceptanceTest
class CommandItemSaveServiceTest {

    @Autowired
    private CommandItemSaveService commandItemSaveService;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    @DisplayName("상품 정보를 바탕으로 해당 상품을 DB에 저장합니다")
    void commandItemSaveService() {
        // given
        ItemSaveRequestDto dto = ItemSaveRequestDto.builder()
                .itemName("상품 이름")
                .itemPrice(50000)
                .stockQuantity(3000)
                .shoeSize(ShoeSize.SIZE_260)
                .topSize(TopSize.L)
                .bottomSize(BottomSize.SIZE_30)
                .build();

        // when
        commandItemSaveService.command(dto);

        // then
        assertThat(itemRepository.count()).isEqualTo(1);
    }
}