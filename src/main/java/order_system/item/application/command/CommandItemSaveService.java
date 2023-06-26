package order_system.item.application.command;

import order_system.item.domain.entity.ItemJpaEntity;
import order_system.item.mapper.ItemMapper;
import order_system.item.mapper.dto.ItemSaveRequestDto;
import order_system.item.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CommandItemSaveService {

    private final ItemRepository itemRepository;

    public CommandItemSaveService(final ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void command(final ItemSaveRequestDto dto) {
        ItemJpaEntity entity = ItemMapper.toEntity(dto);
        itemRepository.save(entity);
    }
}
