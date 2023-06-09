package com.damiantomczyszyn.bookstore.controller;

import com.damiantomczyszyn.bookstore.dto.cart.UserDTO;
import com.damiantomczyszyn.bookstore.entity.User;
import com.damiantomczyszyn.bookstore.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class LoginController {

    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDTO){
        return loginService.authenticate(userDTO);
    }



}
