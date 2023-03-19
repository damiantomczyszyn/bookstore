package com.damiantomczyszyn.bookstore.security;

import com.damiantomczyszyn.bookstore.service.CustomUserDetailsService;
import com.damiantomczyszyn.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

    @Configuration
    @EnableWebSecurity
    public class SecurityConfiguration {

        @Autowired
        UserService userService;

        @Bean
        UserDetailsService userDetailsService(){
            return new CustomUserDetailsService();
        }
        @Bean
        public BCryptPasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
       /* @Bean
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

        */
        @Bean
        SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
            return httpSecurity.csrf().disable()
                    .authorizeHttpRequests(requests -> {
                       // requests.requestMatchers("/v1/home").hasRole("ADMIN");
                       // requests.requestMatchers("/v2/home").hasRole("USER");
                       // requests.requestMatchers("/admin/adduser").hasRole("ADMIN");
                       // requests.anyRequest().denyAll();
                        requests.anyRequest().permitAll();

                    })
                    .httpBasic(Customizer.withDefaults())
                    .build();
        }


        @Bean
        public WebSecurityCustomizer webSecurityCustomizer() {
            return (web) -> web.ignoring().requestMatchers("/images/**", "/js/**", "/webjars/**");
        }

    }
