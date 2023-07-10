package com.mohsenfn.authservice.Service;

import com.mohsenfn.authservice.Entity.User;
import com.mohsenfn.authservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserIService {
    @Autowired
    UserRepository ur;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public String addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        ur.save(user);
        return "user added";
    }
}
