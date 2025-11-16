package com.security.security_Tesing.Service;

import com.security.security_Tesing.Model.Users;
import com.security.security_Tesing.Repo.MyUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private MyUsers repo;

    public List<Users> getAllUserService(){
        return repo.findAll();
    }
    public Users register(Users user){

        return repo.save(user);

    }
}
