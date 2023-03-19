package com.damiantomczyszyn.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.damiantomczyszyn.bookstore.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

}
