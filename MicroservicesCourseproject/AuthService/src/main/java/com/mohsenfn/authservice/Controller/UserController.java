package com.mohsenfn.authservice.Controller;

import com.mohsenfn.authservice.Entity.User;
import com.mohsenfn.authservice.Service.UserIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    UserIService uis;
  @PostMapping("/register")
    public String addUser(@RequestBody User user) {
        return uis.addUser(user);
    }

   @PostMapping("/token")
    public String generateToken(@RequestBody User user) {
        return uis.generateToken(user.getName());
    }

    @GetMapping("/validate")
    public void validateToken(@RequestParam String token) {
       uis.validateToken(token);
    }
}
