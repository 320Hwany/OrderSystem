package order_system.item.presentation;

import order_system.item.application.command.CommandItemSaveService;
import order_system.item.mapper.dto.ItemSaveRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class ItemRestController {

    private final CommandItemSaveService commandItemSaveService;

    public ItemRestController(final CommandItemSaveService commandItemSaveService) {
        this.commandItemSaveService = commandItemSaveService;
    }

    @PostMapping("/item")
    public void save(@RequestBody final ItemSaveRequestDto dto) {
        commandItemSaveService.command(dto);
    }
}
