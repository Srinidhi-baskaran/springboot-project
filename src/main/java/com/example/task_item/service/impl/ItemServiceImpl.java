package com.example.task_item.service.impl;

import com.example.task_item.Exception.ResourceNotFoundException;
import com.example.task_item.ItemRepository;
import com.example.task_item.entities.CreateItem;
import com.example.task_item.entities.Item;
import com.example.task_item.service.ItemService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    @Override
    public Item CreateItem(CreateItem create) {
        Instant now =Instant.now();
        Item item = new Item(
                create.name(),
                create.description(),
                now,
                now
        );
        return itemRepository.save(item);
    }

    @Override
    public List<Item> listItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(Integer id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Item not found with id " + id
                ));
    }


}
