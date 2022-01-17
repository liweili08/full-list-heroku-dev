package com.example.mongodb;

import com.example.mongodb.model.ListItem;
import com.example.mongodb.repository.ListRepo;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import java.util.UUID;

@SpringBootApplication
public class MongodbApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class, args);
    }

   // @Value("${spring.data.mongodb.database}")
   // String db;

    @Autowired
    ListRepo listRepo;

    @Override
    public void run(String... args) throws Exception {
        ListItem gurke = ListItem.builder().itemName("Eier").quantity(2).build();
        ListItem eis = ListItem.builder().itemName("Salat").quantity(3).build();
        //ListItem eis = ListItem.builder().itemName("Salat").itemKey(UUID.randomUUID().toString()).quantity(3).build();
       // System.out.println(db);
    }
}
