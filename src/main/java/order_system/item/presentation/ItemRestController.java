package order_system.item.presentation;

import order_system.item.application.command.CommandItemSaveService;
import order_system.item.application.command.CommandItemUpdateService;
import order_system.item.domain.Item;
import order_system.item.mapper.ItemMapper;
import order_system.item.mapper.dto.ItemResponseDto;
import order_system.item.mapper.dto.ItemSaveRequestDto;
import order_system.item.mapper.dto.ItemUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class ItemRestController {

    private final CommandItemSaveService commandItemSaveService;
    private final CommandItemUpdateService commandItemUpdateService;

    public ItemRestController(final CommandItemSaveService commandItemSaveService,
                              final CommandItemUpdateService commandItemUpdateService) {
        this.commandItemSaveService = commandItemSaveService;
        this.commandItemUpdateService = commandItemUpdateService;
    }

    @PostMapping("/item")
    public void save(@RequestBody final ItemSaveRequestDto dto) {
        commandItemSaveService.command(dto);
    }

    @PatchMapping("/item")
    public ItemResponseDto update(@RequestBody final ItemUpdateRequestDto dto) {
        Item item = commandItemUpdateService.command(dto);
        return ItemMapper.toResponseDto(item);
    }
}
