package com.damiantomczyszyn.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.core.SpringVersion;


@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {
        //System.out.println(SpringVersion.getVersion());
        SpringApplication.run(BookstoreApplication.class, args);
    }

}
