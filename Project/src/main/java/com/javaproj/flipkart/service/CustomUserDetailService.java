package com.javaproj.flipkart.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javaproj.flipkart.model.CustomUserDetail;
import com.javaproj.flipkart.model.User;
import com.javaproj.flipkart.repo.UserRepo;


@Service
public class CustomUserDetailService implements UserDetailsService{
    @Autowired
    UserRepo userRepo;
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findUserByEmail(email);
        user.orElseThrow(() -> new UsernameNotFoundException("Could not find user"));
        return user.map(CustomUserDetail::new).get();

    }
}
