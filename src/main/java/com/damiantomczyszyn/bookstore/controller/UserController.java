package com.damiantomczyszyn.bookstore.controller;


import com.damiantomczyszyn.bookstore.entity.User;
import com.damiantomczyszyn.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/user")
    public UserDetails user(@RequestParam String email){

        return  userService.loadUserByUsername(email);
    }

    @GetMapping("/users")
    public List<User> users(){

        return userService.readAll();
    }

    @GetMapping("/userz")
    public String userz(){
        String email = "damian1@email.com";
        return userService.loadUserByUsername(email).toString();
    }

    @PostMapping("/adduser")
    public ResponseEntity user(@RequestBody User user){
        userService.save(user);
        return ResponseEntity.created(URI.create("/user")).build();
    }



}
