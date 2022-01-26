package com.example.mongodb.service;

import com.example.mongodb.model.ListItem;
import com.example.mongodb.repository.ListRepo;
import org.springframework.stereotype.Service;

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
        if(itemToAdd.getItemKey()==null) {
            listRepo.save(itemToAdd);
            return getAllItems();
        }else if (listRepo.findById(itemToAdd.getItemKey()).isPresent()) {
                return getAllItems();
            }
            else{
                listRepo.save(itemToAdd);
                return getAllItems();
            }
        }

    public List<ListItem> increaseQuantity(String itemKey) {
        ListItem itemToIncrease = listRepo.findById(itemKey).get();
        itemToIncrease.setItemQuantity(itemToIncrease.getItemQuantity()+1);
        listRepo.save(itemToIncrease);
        return getAllItems();
    }

    public List<ListItem> decreaseQuantity(String itemKey) {
        ListItem itemToDecrease = listRepo.findById(itemKey).get();
        int quantity= itemToDecrease.getItemQuantity();
        if(quantity <=1){
            return removeItem(itemKey);
        }
        itemToDecrease.setItemQuantity(quantity-1);
        listRepo.save(itemToDecrease);
        return getAllItems();
    }

    public List<ListItem> removeItem(String itemKey) {
       // if()
        //listRepo.save(itemToDelete);
        ListItem itemToDelete = listRepo.findById(itemKey).get();
        listRepo.deleteById(itemToDelete.getItemKey());
        return getAllItems();
    }

}
