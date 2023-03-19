package com.damiantomczyszyn.bookstore;

import com.damiantomczyszyn.bookstore.entity.User;
import com.damiantomczyszyn.bookstore.repository.UserRepository;
import com.damiantomczyszyn.bookstore.security.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class DatabaseLoader {
    private UserRepository repo;

    public  DatabaseLoader(UserRepository repo){
        this.repo=repo;
    }
    @Bean
    public CommandLineRunner initializeDatabase() {
        return args -> {

            User user1 = new User(1L,"user@codejava.com", "pass", Role.USER);
            User user2 = new User(2L,"admin@codejava.com", "pass", Role.ADMIN);

        repo.saveAll(List.of(user1,user2));
        };
    }
}
