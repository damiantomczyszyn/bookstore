package com.damiantomczyszyn.bookstore.service;

import com.damiantomczyszyn.bookstore.entity.User;
import com.damiantomczyszyn.bookstore.repository.UserRepository;
import com.damiantomczyszyn.bookstore.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = repo.findByEmail(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return new CustomUserDetails(user);
        } else {
            throw new UsernameNotFoundException("nof found for given email");
        }
    }
}