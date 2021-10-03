package dev.isurubuddhika.driw.service.impl;

import dev.isurubuddhika.driw.dto.ItemDTO;
import dev.isurubuddhika.driw.repository.ItemRepository;
import dev.isurubuddhika.driw.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    
    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<ItemDTO> getAll() {
        return itemRepository.findAll().stream()
                .map(item -> new ItemDTO(item.getItemId(), item.getName(), item.getPricePerCarton(), item.getItemsPerCarton()))
                .collect(Collectors.toList());
    }
}
