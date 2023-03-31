package com.damiantomczyszyn.bookstore;

import com.damiantomczyszyn.bookstore.entity.User;
import com.damiantomczyszyn.bookstore.repository.UserRepository;
import com.damiantomczyszyn.bookstore.security.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
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

            System.out.println("zapisywanie usera i admina");
        repo.saveAll(List.of(user1,user2));
            System.out.println("Odczyt usera i admina:");
            List<User> users = repo.findAll();
            for (User u: users) {
                System.out.println(u.toString());
            }
        };



    }
}
