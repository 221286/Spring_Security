package com.security.security_Tesing.Service;

import com.security.security_Tesing.Model.UserPrincipal;
import com.security.security_Tesing.Model.Users;
import com.security.security_Tesing.Repo.MyUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private MyUsers myUsers;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> userCheck=myUsers.findByUsername(username);
        Users user=userCheck.orElseThrow(()->new UsernameNotFoundException("user not found"));

//        if(userCheck==null){
//            System.out.println("User not found");
//            throw new UsernameNotFoundException("user not found");
//        }
        return new UserPrincipal(user);
    }
}
