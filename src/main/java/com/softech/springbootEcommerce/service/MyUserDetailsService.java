package com.softech.springbootEcommerce.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private Map<String,String> users = Map.of(
        "Rahul@gmail.com","987654321"
    );
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password = users.get(username);
        if(password == null){
            throw new UsernameNotFoundException("Username or Password Incorrect");
        }
        return new User(username,password,new ArrayList<>());
    }
}
