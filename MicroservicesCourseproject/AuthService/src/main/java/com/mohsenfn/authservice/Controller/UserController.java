package com.mohsenfn.authservice.Controller;

import com.mohsenfn.authservice.Entity.User;
import com.mohsenfn.authservice.Service.UserIService;
import com.mohsenfn.authservice.dto.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    UserIService uis;
    @Autowired
    AuthenticationManager authenticationManager;
   @PostMapping("/register")
    public String addUser(@RequestBody User user) {
        return uis.addUser(user);
    }
   @PostMapping("/token")
    public String generateToken(@RequestBody UserRequest user) {
     Authentication a= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(),user.getPassword()));
      if(a.isAuthenticated()) {
          return uis.generateToken(user.getName());
      }
      else {
          throw new RuntimeException("invalid information");
      }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam String token) {
       uis.validateToken(token);
       return "validate token";
    }
}
