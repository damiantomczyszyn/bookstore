package com.damiantomczyszyn.bookstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @Column(name = "id")
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    //user foreign key //UserDetails
    //is paid
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;
    boolean isPaid;


}
