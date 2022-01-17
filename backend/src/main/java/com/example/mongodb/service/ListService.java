package com.example.mongodb.service;

import com.example.mongodb.model.ListItem;
import com.example.mongodb.repository.ListRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListService {
    private final ListRepo listRepo;

    public ListService(ListRepo listRepo) {
        this.listRepo = listRepo;
    }
//********* Methoden ********
public List<ListItem> getAllItems() {
    return listRepo.findAll();
}

    public List<ListItem> addItem(ListItem itemToAdd) {
        if (listRepo.findById(itemToAdd.getItemKey()).isPresent()) {
            return getAllItems();
        }
            listRepo.save(itemToAdd);
            return getAllItems();

    }

    public List<ListItem> increaseQuantity(String itemKey) {
        ListItem itemToIncrease = listRepo.findById(itemKey).get();
        itemToIncrease.setQuantity(itemToIncrease.getQuantity()+1);
        listRepo.save(itemToIncrease);
        return getAllItems();
    }

    public List<ListItem> decreaseQuantity(String itemKey) {
        ListItem itemToDecrease = listRepo.findById(itemKey).get();
        if(itemToDecrease.getQuantity()<=1){
            return removeItem(itemKey);
        }
        itemToDecrease.setQuantity(itemToDecrease.getQuantity()-1);
        return getAllItems();
    }

    public List<ListItem> removeItem(String itemKey) {
        listRepo.deleteById(itemKey);
        return getAllItems();
    }

}
