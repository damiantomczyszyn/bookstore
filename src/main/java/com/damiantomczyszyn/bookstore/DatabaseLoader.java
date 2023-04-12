package com.damiantomczyszyn.bookstore;

import com.damiantomczyszyn.bookstore.entity.Book;
import com.damiantomczyszyn.bookstore.entity.Cart;
import com.damiantomczyszyn.bookstore.entity.User;
import com.damiantomczyszyn.bookstore.repository.BookRepository;
import com.damiantomczyszyn.bookstore.repository.UserRepository;
import com.damiantomczyszyn.bookstore.security.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class DatabaseLoader {
    private UserRepository repo;
    private BookRepository bookRepository;

    public  DatabaseLoader(UserRepository repo, BookRepository bookRepository){
        this.repo=repo;
        this.bookRepository=bookRepository;
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

            Book book1 = new Book(1L,"Hary Potter","40","J.K Rownling","10-10-2000");
            Book book2 = new Book(2L,"Pinokio","20","Gepetto","10-01-1859");
            Book book3 = new Book(3L,"Wieloryb bundy","35","Krokodyl","10-12-2005");
            bookRepository.saveAll(List.of(book1,book2,book3));
            List<Book> books = bookRepository.findAll();
            for (Book b : books) {
                System.out.println(b.toString());
            }

        };



    }
}
