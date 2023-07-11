package com.mohsenfn.authservice.Service;

import com.mohsenfn.authservice.Entity.User;

public interface UserIService {
    public String addUser(User user);
    public String generateToken(String username);
    public void validateToken(String token);
}
