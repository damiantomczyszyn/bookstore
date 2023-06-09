package com.damiantomczyszyn.bookstore.service;

import com.damiantomczyszyn.bookstore.dto.cart.UserDTO;
import com.damiantomczyszyn.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {


    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public LoginService(AuthenticationManager authenticationManager, UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity<UserDTO> authenticate(UserDTO LoginDTO) {
        if ()
    }
}

