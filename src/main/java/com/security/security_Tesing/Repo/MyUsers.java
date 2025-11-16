package com.security.security_Tesing.Repo;

import com.security.security_Tesing.Model.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyUsers extends JpaRepository<Users,Integer> {

     Optional<Users>  findByUsername(String userName);
}
