package order_system.item.presentation;

import order_system.item.application.command.CommandItemSaveService;
import order_system.item.application.command.CommandItemUpdateService;
import order_system.item.application.query.QueryItemByIdService;
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
    private final QueryItemByIdService queryItemByIdService;

    public ItemRestController(final CommandItemSaveService commandItemSaveService,
                              final CommandItemUpdateService commandItemUpdateService,
                              final QueryItemByIdService queryItemByIdService) {
        this.commandItemSaveService = commandItemSaveService;
        this.commandItemUpdateService = commandItemUpdateService;
        this.queryItemByIdService = queryItemByIdService;
    }

    @PostMapping("/item")
    public void save(@RequestBody final ItemSaveRequestDto dto) {
        commandItemSaveService.command(dto);
    }

    @GetMapping("/item/{itemId}")
    public ItemResponseDto get(@PathVariable final long itemId) {
        Item item = queryItemByIdService.query(itemId);
        return ItemMapper.toResponseDto(item);
    }

    @PatchMapping("/item")
    public ItemResponseDto update(@RequestBody final ItemUpdateRequestDto dto) {
        Item item = commandItemUpdateService.command(dto);
        return ItemMapper.toResponseDto(item);
    }
}
