package com.damiantomczyszyn.bookstore;

import com.damiantomczyszyn.bookstore.entity.User;
import com.damiantomczyszyn.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DatabaseLoader {
    @Autowired
    private UserRepository repo;
    public DatabaseLoader(UserRepository repo){
        this.repo = repo;
    }
    @Bean
    public CommandLineRunner initializeDatabase() {
        return  args -> {
            User user1 = new User();
            User user2 = new User();
            User user3 = new User();

            repo.saveAll(List.of(user1,user2,user3));
            System.out.println("sample users initialized");
        };
    }
}
