package com.example.mongodb.service;

import com.example.mongodb.model.ListItem;
import com.example.mongodb.repository.ListRepo;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ListServiceTest {

    private final ListRepo listRepo = mock(ListRepo.class);

    private final ListService listService = new ListService(listRepo);

    @Test
    void getAllItems() {
        //GIVEN
        ListItem test1 = ListItem.builder()
                .itemKey(UUID.randomUUID().toString())
                .itemName("test1-name")
                .itemQuantity(1)
                .build();
        List<ListItem> testList= new ArrayList<ListItem>();
        testList.add(test1);

        when(listRepo.findAll()).thenReturn(testList);//THEN
        assertThat(testList, Matchers.is(testList));

    }

    @Test
    void addItemWithExistingId() {
        ListItem itemToAdd = ListItem.builder()
                .itemKey("test-test")
                .itemName("new-name")
                .itemQuantity(1)
                .build();
        List<ListItem> testList= new ArrayList<ListItem>();
        //testList.add(itemToAdd);
        when(listRepo.findById("test-test")).thenReturn(Optional.of(itemToAdd));
        when(listRepo.findAll()).thenReturn(testList);
        List<ListItem> aktual = listService.addItem(itemToAdd);

        assertThat(aktual.size(), Matchers.is(testList.size()));
    }

    @Test
    void addItemWithNewId() {
        ListItem itemToAdd = ListItem.builder()
                .itemKey("test-test")
                .itemName("new-name")
                .itemQuantity(1)
                .build();
        List<ListItem> testList= new ArrayList<ListItem>();
        testList.add(itemToAdd);
        when(listRepo.findById("test-test")).thenReturn(Optional.empty());
        when(listRepo.findAll()).thenReturn(testList);
        List<ListItem> aktual = listService.addItem(itemToAdd);

        assertThat(aktual.size(), Matchers.is(testList.size()));
        assertThat(aktual.get(0).getItemName(), Matchers.is("new-name"));
    }


    @Test
    void increaseQuantity() {
    }

    @Test
    void decreaseQuantity() {
    }

    @Test
    void removeItem() {
    }
}