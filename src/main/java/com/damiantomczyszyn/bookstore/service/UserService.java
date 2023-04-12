package com.damiantomczyszyn.bookstore.service;


import com.damiantomczyszyn.bookstore.entity.Book;
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
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    public UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow( () -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());

    }

    public List<User> readAll(){
        if (!userRepository.findAll().isEmpty())
            return userRepository.findAll().stream().toList();
        return null;
    }

    public void save(User user) {
        userRepository.save(user);
    }
    public Object getLoggedUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getDetails();
    }

    public void saveOrUpdate(User user) {
        userRepository.save(user);
    }
}
