package com.example.mongodb.controller;

import com.example.mongodb.model.LoginData;
import com.example.mongodb.service.JWTUtilsService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;

@RestController
@RequestMapping("auth/login")
public class LoginController {
   final AuthenticationManager authenticationManager;
    final JWTUtilsService jwtService;

    public LoginController(AuthenticationManager authenticationManager, JWTUtilsService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping
    public String postLogin(@RequestBody LoginData data){
        try {
            //darf der User sich anmelden?
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(data.getName(), data.getPassword())
            );
            return jwtService.createToken(new HashMap<>(), data.getName());
        } catch (AuthenticationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid credentials");
        }
    }


}
