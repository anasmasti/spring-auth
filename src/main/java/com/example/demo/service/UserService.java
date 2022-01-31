package com.example.demo.service;


import java.util.List;

import com.example.demo.DAO.UserDAO;
import com.example.demo.model.AppUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserDAO userDAO;
    
    public AppUser postUser(AppUser appUser) {
        return userDAO.save(appUser);
    }

    public List<AppUser> getUsers() {
        return userDAO.findAll();
    }
    
    @Bean
    final PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("anas", passwordEncoder().encode("123"), AuthorityUtils.NO_AUTHORITIES);
    }

}
