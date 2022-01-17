package com.example.mongodb.repository;

import com.example.mongodb.model.ListItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ListRepo extends MongoRepository<ListItem,String> {

    //ArrayList<ListItem> findAll();
}
