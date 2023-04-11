package com.damiantomczyszyn.bookstore.entity;

import jakarta.persistence.*;

import org.springframework.security.core.userdetails.UserDetails;
import com.damiantomczyszyn.bookstore.entity.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "cart")
    private List<Book> books;

    public Cart(Long id) {
        this.id = id;
    }

    public Cart() {
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Cart(Long id, User user, List<Book> books) {
        this.id = id;
        this.user = user;
        this.books = books;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
