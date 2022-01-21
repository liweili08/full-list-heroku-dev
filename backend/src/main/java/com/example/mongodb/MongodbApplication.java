package com.example.mongodb;

import com.example.mongodb.model.ListItem;
import com.example.mongodb.model.UserMongo;
import com.example.mongodb.repository.ListRepo;
import com.example.mongodb.repository.UserRepository;
import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoWriteException;
import lombok.Getter;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.UUID;

//import java.util.UUID;

//@EnableMongoRepositories(repositoryBaseClass = UserRepository.class) //kann weg
@SpringBootApplication
public class MongodbApplication implements CommandLineRunner {

    private static final Log LOG= LogFactory.getLog(MongodbApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class, args);
    }

   // @Value("${spring.data.mongodb.database}")
   // String db;

    @Autowired
    ListRepo listRepo;
    @Autowired
    UserRepository userRepo;
    @Autowired
    PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {
        //ListItem eis = ListItem.builder().itemName("Salat").quantity(3).build();
        //ListItem salat = ListItem.builder().itemName("Salat").itemKey(UUID.randomUUID().toString()).quantity(3).build();
        //listRepo.insert(salat);
       // System.out.println(db);

        // UserMongo liwei = UserMongo.builder().username("Liwei").password("12345").build();
        //  userRepo.save(liwei);

        final String encodePassword = encoder.encode("123456");
        final UserMongo userAdmin = UserMongo.newUserMongo("Admin", encodePassword, List.of(new SimpleGrantedAuthority("API_READWRITE")));
        /*try{
            userRepo.insert(userAdmin);
        } catch (MongoWriteException e){
            LOG.info("User" + userAdmin.getUsername() + " already exists.");
        }*/
        if(userRepo.findByUsername(userAdmin.getUsername()).isEmpty()){
            userRepo.insert(userAdmin);
        }else{
            LOG.info("User" + userAdmin.getUsername() + " already exists.");
        }

    }
}
