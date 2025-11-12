package com.security.security_Tesing.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @GetMapping("/")
    public String greet(HttpServletRequest request){
        return "Hello Anis " + request.getSession().getId();
    }

}
