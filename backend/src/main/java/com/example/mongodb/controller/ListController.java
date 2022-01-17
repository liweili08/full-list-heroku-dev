package com.example.mongodb.controller;

import com.example.mongodb.model.ListItem;
import com.example.mongodb.service.ListService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping({"${spring.datasource.url}"})
public class ListController {
    private final ListService listService;

    public ListController(ListService listService) {
        this.listService = listService;
    }

    //*********** Methoden *********
    @GetMapping("lists")
    public List<ListItem> getAll() {
        return listService.getAllItems();
    }

    @PostMapping("lists")
    public List<ListItem> postAddItem(@RequestBody ListItem itemToAdd){
        return listService.addItem(itemToAdd);
    }

    @PutMapping("lists/{itemKey}")
    public List<ListItem> putIncreaseQuantity(@PathVariable String itemKey){
        return listService.increaseQuantity(itemKey);
    }

    @PutMapping("lists/{itemKey}/decrease")
    public List<ListItem> putDecreaseQuantity(@PathVariable String itemKey){
        return listService.decreaseQuantity(itemKey);
    }

    @DeleteMapping("lists/")
    public List<ListItem> deleteItem(@PathVariable String itemKey){
        return listService.removeItem(itemKey);
    }




}
