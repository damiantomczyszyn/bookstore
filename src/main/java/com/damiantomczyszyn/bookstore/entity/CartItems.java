package com.damiantomczyszyn.bookstore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import org.springframework.data.rest.core.annotation.RestResource;

@Entity
public class CartItems {
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @OneToOne
    @JoinColumn(name = "book_id")
    @RestResource(path = "libraryAddress", rel="address")
    private Book book;

    //cart foreign key
    // book foreign key


}
