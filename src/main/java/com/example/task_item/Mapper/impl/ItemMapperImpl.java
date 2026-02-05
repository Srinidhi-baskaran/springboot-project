package com.example.task_item.Mapper.impl;

import com.example.task_item.Dto.CreateItemDto;
import com.example.task_item.Dto.ItemDto;
import com.example.task_item.Mapper.ItemMapper;
import com.example.task_item.entities.CreateItem;
import com.example.task_item.entities.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public CreateItem fromDto(CreateItemDto dto) {
        return  new CreateItem( dto.name(), dto.description());
    }

    @Override
    public ItemDto toDto(Item item) {
        return new ItemDto(item.getId(), item.getName(), item.getDescription());
    }
}
