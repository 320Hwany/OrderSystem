package order_system.item.application.query;

import order_system.item.domain.Item;
import order_system.item.domain.entity.ItemJpaEntity;
import order_system.item.mapper.ItemMapper;
import order_system.item.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class QueryItemByIdService {

    private final ItemRepository itemRepository;

    public QueryItemByIdService(final ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item query(final long itemId) {
        ItemJpaEntity entity = itemRepository.getById(itemId);
        return ItemMapper.toDomain(entity);
    }
}
