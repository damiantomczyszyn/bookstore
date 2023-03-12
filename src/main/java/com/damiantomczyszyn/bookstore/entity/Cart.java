package com.damiantomczyszyn.bookstore.entity;

import jakarta.persistence.*;
import org.apache.catalina.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Cart {
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    //user foreign key //UserDetails
    //is paid


}
