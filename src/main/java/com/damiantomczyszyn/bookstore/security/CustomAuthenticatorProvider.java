package com.damiantomczyszyn.bookstore.security;

import com.damiantomczyszyn.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomAuthenticatorProvider implements AuthenticationProvider {
    @Autowired
    UserRepository repository;


    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        if (shouldAuthenticateAgainstThirdPartySystem(name, password)) {



            // use the credentials
            // and authenticate against the third-party system
            return new UsernamePasswordAuthenticationToken(
                    name, password, new ArrayList<>());
        } else {
            return null;
        }
    }

    private boolean shouldAuthenticateAgainstThirdPartySystem(String name, String password) {
        var userOptional = repository.findByEmail(name);

        if(userOptional.isPresent()){
            if(userOptional.get().getPassword().equals(password)){

                return true;
            }
        }
        return false;
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}