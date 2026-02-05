package com.example.task_item.controller;

import com.example.task_item.Dto.CreateItemDto;
import com.example.task_item.Dto.ItemDto;
import com.example.task_item.Mapper.ItemMapper;
import com.example.task_item.entities.CreateItem;
import com.example.task_item.entities.Item;
import com.example.task_item.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/v1/items")
public class ItemController {

    private final ItemService itemService;
    private final ItemMapper itemMapper;

    public ItemController(ItemService itemService, ItemMapper itemMapper) {
        this.itemService = itemService;
        this.itemMapper = itemMapper;
    }

    @PostMapping
    public ResponseEntity<ItemDto> createItem(@Valid @RequestBody CreateItemDto createItemDto)
    {
        CreateItem createItem = itemMapper.fromDto(createItemDto);
        Item item = itemService.CreateItem(createItem);
        ItemDto createDto = itemMapper.toDto(item);
        return new ResponseEntity<>(createDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ItemDto>> getItems(){
        List<ItemDto> categories=itemService.listItems().stream().map(itemMapper::toDto)
                .toList();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> getItemById(@PathVariable Integer id) {
        Item item = itemService.getItemById(id);
        return ResponseEntity.ok(itemMapper.toDto(item));
    }


}
