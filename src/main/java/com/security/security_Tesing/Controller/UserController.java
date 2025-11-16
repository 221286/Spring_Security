package com.security.security_Tesing.Controller;

import com.security.security_Tesing.Model.Users;
import com.security.security_Tesing.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registration")
public class UserController {

    @Autowired
    private UserService userService;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
    @GetMapping("/getAllUser")
    public List<Users> getUsers(){
        return userService.getAllUserService();
    }
    @PostMapping("/register")
    public Users registerUser(@RequestBody Users user){
       user.setPassword(encoder.encode(user.getPassword()));
        return userService.register(user);
    }
}
