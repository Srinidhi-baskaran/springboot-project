package com.example.task_item.Mapper;

import com.example.task_item.Dto.CreateItemDto;
import com.example.task_item.Dto.ItemDto;
import com.example.task_item.entities.CreateItem;
import com.example.task_item.entities.Item;

public interface ItemMapper {

    CreateItem fromDto(CreateItemDto dto);

    ItemDto toDto(Item item);
}
