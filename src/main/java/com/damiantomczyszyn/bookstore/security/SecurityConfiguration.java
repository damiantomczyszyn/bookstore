package com.damiantomczyszyn.bookstore.security;

import com.damiantomczyszyn.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
        private CustomAuthenticatorProvider authProvider;

        @Bean
        public AuthenticationManager authManager(HttpSecurity http) throws Exception {
            AuthenticationManagerBuilder authenticationManagerBuilder =
                    http.getSharedObject(AuthenticationManagerBuilder.class);
            authenticationManagerBuilder.authenticationProvider(authProvider);
            return authenticationManagerBuilder.build();
        }

        @Bean
        public InMemoryUserDetailsManager userDetailsService() {
            UserDetails user1 = User.withUsername("user1")
                    .password(passwordEncoder().encode("user1Pass"))
                    .roles("USER")
                    .build();
            UserDetails user2 = User.withUsername("user2")
                    .password(passwordEncoder().encode("user2Pass"))
                    .roles("USER")
                    .build();
            UserDetails admin = User.withUsername("admin")
                    .password(passwordEncoder().encode("adminPass"))
                    .roles("ADMIN")
                    .build();
            return new InMemoryUserDetailsManager(user1, user2, admin);
        }
        @Bean
        SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
            return httpSecurity.csrf().disable()


                    .authorizeHttpRequests()
                    .requestMatchers("/v1/addbook").permitAll()
                    .and()


                    //.authorizeHttpRequests().anyRequest().permitAll()

                    .authorizeHttpRequests()
                    .requestMatchers("/v1/books").authenticated()

                    .and().formLogin()
                    .and()
                   // .httpBasic(Customizer.withDefaults())//dodanie tego sprawia ze dziala
                    .build();


        }


        @Bean
        public WebSecurityCustomizer webSecurityCustomizer() {
            return (web) -> web.ignoring().requestMatchers("/images/**", "/js/**", "/webjars/**");
        }

    }
