package com.damiantomczyszyn.bookstore.security;

import com.damiantomczyszyn.bookstore.service.CustomUserDetailsService;
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
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

    @Configuration
    @EnableWebSecurity
    public class SecurityConfiguration {
        @Bean
        public UserDetailsService userDetailsService(){
            return new CustomUserDetailsService();
        }

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


                    .authorizeHttpRequests()
                    .requestMatchers("/v1/addbook", "/v1/book/**").hasRole("ADMIN")
                    .anyRequest().permitAll()//.authenticated()
                    .and()
                    .httpBasic()

                    .and().formLogin()


                    .and()

                    .build();


        }


        @Bean
        public WebSecurityCustomizer webSecurityCustomizer() {
            return (web) -> web.ignoring().requestMatchers("/images/**", "/js/**", "/webjars/**");
        }

    }
