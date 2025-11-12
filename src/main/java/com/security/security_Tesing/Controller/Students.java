package com.security.security_Tesing.Controller;

import com.security.security_Tesing.Entity.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Students {
   private List<Student> li=new ArrayList<>(List.of(new Student(1,"Anis",30)));
    @GetMapping("/student")
    public List<Student> getStudent(){
        return li;
    }
    @PostMapping("/addStudent")
    public List<Student> addStudent(Student s){
        li.add(s);
        return li;
    }
    @GetMapping("csrf-token")
    public CsrfToken getCSRFToken(HttpServletRequest req){
        return (CsrfToken) req.getAttribute("_csrf");
    }
}
