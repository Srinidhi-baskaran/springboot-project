package com.example.task_item.service;

import com.example.task_item.entities.CreateItem;
import com.example.task_item.entities.Item;

import java.util.List;

public interface ItemService {

    Item CreateItem(CreateItem item);

    List<Item> listItems();

    Item getItemById(Integer id);

}
