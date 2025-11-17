package com.security.security_Tesing.Service;

import com.security.security_Tesing.Model.Users;
import com.security.security_Tesing.Repo.MyUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private MyUsers repo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    public List<Users> getAllUserService(){
        return repo.findAll();
    }
    public Users register(Users user){

        return repo.save(user);

    }

    public String verify(Users user) {
        Authentication authentication=
                authenticationManager.authenticate
                        (new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(user.getUsername());
        }else{
            return "Failure";
        }
    }
}
