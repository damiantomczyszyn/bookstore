package com.damiantomczyszyn.bookstore.security;

import com.damiantomczyszyn.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    UserService userService;
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private CustomAuthenticationProvider authProvider;



    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(authProvider);
        return authenticationManagerBuilder.build();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf().disable()
                // .authorizeHttpRequests().anyRequest().permitAll()


                .authorizeHttpRequests()
                .requestMatchers("/v1/addbook").permitAll()
                .and()

                .authorizeHttpRequests()
                .requestMatchers("/v1/carts").permitAll()
                .and()

                .authorizeHttpRequests()
                .requestMatchers("/v1/additem/{bookId}").permitAll()
                .and()


                .authorizeHttpRequests()
                .requestMatchers("/v1/addcart").permitAll()
                .and()

                .authorizeHttpRequests()
                .requestMatchers("/v1/updateuser").permitAll()
                .and()

                .authorizeHttpRequests()
                .requestMatchers("/v1/*").permitAll()
                .and()

                .authorizeHttpRequests()
                .requestMatchers("/admin/*").permitAll()
                .and()

                //.authorizeHttpRequests().anyRequest().permitAll()

                .authorizeHttpRequests()
                .requestMatchers("/v1/books").authenticated()

                .and().formLogin()


                .and()
                // .httpBasic(Customizer.withDefaults())//dodanie tego sprawia ze dziala
                .build();


    }





}