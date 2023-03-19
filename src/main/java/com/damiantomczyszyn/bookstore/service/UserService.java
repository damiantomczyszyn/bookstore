package com.damiantomczyszyn.bookstore.service;


import com.damiantomczyszyn.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;


import com.damiantomczyszyn.bookstore.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow( () -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());

    }

    public void save(User user) {
        userRepository.save(user);
    }
    public Object getLoggedUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getDetails();
    }
}
