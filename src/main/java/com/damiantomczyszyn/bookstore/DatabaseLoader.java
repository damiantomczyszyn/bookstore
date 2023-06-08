package com.damiantomczyszyn.bookstore;

import com.damiantomczyszyn.bookstore.entity.Book;
import com.damiantomczyszyn.bookstore.entity.Cart;
import com.damiantomczyszyn.bookstore.entity.CartItem;
import com.damiantomczyszyn.bookstore.entity.User;
import com.damiantomczyszyn.bookstore.repository.BookRepository;
import com.damiantomczyszyn.bookstore.repository.CartItemRepository;
import com.damiantomczyszyn.bookstore.repository.CartRepository;
import com.damiantomczyszyn.bookstore.repository.UserRepository;
import com.damiantomczyszyn.bookstore.security.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Configuration
public class DatabaseLoader {
    private UserRepository repo;
    private BookRepository bookRepository;
    private CartRepository cartRepository;
    private CartItemRepository cartItemRepository;

    public  DatabaseLoader(UserRepository repo, BookRepository bookRepository, CartRepository cartRepository, CartItemRepository cartItemRepository){
        this.repo=repo;
        this.bookRepository=bookRepository;
        this.cartRepository=cartRepository;
        this.cartItemRepository=cartItemRepository;
    }
    @Bean
    public CommandLineRunner initializeDatabase() {
        return args -> {
            System.out.println("wypisanie");

            User user1 = new User(1L,"user@codejava.com", "pass", Role.USER,new Cart());
            User user2 = new User(2L,"admin@codejava.com", "pass", Role.ADMIN,new Cart());
            User user3 = new User(3L,"user@codeinjava.com", "passwd", Role.USER,new Cart());



            System.out.println("zapisywanie usera i admina");
        repo.saveAll(List.of(user1,user2,user3));
            System.out.println("Odczyt usera i admina:");
            List<User> users = repo.findAll();
            for (User u: users) {
                System.out.println(u.toString());
            }


            Cart cart1 = new Cart(1L,user1,new ArrayList<CartItem>());
            cartRepository.save(cart1);
            //System.out.println(user1.getCart());//null
            user1.setCart(cart1);
            repo.save(user1);
            //System.out.println(user1.getCart()); //ustawiony obiekt



            Book book1 = new Book(1L,"Hary Potter","40","J.K Rownling","10-10-2000");
            Book book2 = new Book(2L,"Pinokio","20","Gepetto","10-01-1859");
            Book book3 = new Book(3L,"Wieloryb bundy","35","Krokodyl","10-12-2005");
            bookRepository.saveAll(List.of(book1,book2,book3));
            List<Book> books = bookRepository.findAll();
            for (Book b : books) {
                System.out.println(b.toString());
            }

            CartItem item1 = new CartItem(1L,book1,2, new BigDecimal(80),cart1);
            cartItemRepository.save(item1);


        };



    }
}
