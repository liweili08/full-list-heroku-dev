package com.example.mongodb.service;

import com.example.mongodb.model.UserMongo;
import com.example.mongodb.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Component
public class MongoUserDetailsService implements UserDetailsService {
    public static final String AUTHORITY_API_READWRITE = "API_READWRITE";
    private final UserRepository userRepository;

    public MongoUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     return userRepository.findByUsername(username)
              .orElseThrow(()->new UsernameNotFoundException("User"+ username +" not found."));

        /*  UserMongo user = userRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new User(user.getUsername(), user.getPassword(),
                List.of(new SimpleGrantedAuthority("user")));*/
    }
}
