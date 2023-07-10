package com.mohsenfn.authservice.Service;

import com.mohsenfn.authservice.Entity.User;
import com.mohsenfn.authservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserIService {
    @Autowired
    UserRepository ur;
    @Override
    public String addUser(User user) {
        ur.save(user);
        return "user added";
    }
}
