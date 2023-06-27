package order_system.item.application.command;

import order_system.item.domain.Item;
import order_system.item.domain.entity.ItemJpaEntity;
import order_system.item.mapper.ItemMapper;
import order_system.item.mapper.dto.ItemUpdateRequestDto;
import order_system.item.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CommandItemUpdateService {

    private final ItemRepository itemRepository;

    public CommandItemUpdateService(final ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item command(final ItemUpdateRequestDto dto) {
        ItemJpaEntity entity = itemRepository.getById(dto.itemId());
        entity.update(dto);
        return ItemMapper.toDomain(entity);
    }
}
