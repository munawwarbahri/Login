package com.amigoscode.repository;

import com.amigoscode.user.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository
    extends JpaRepository<User, Integer> {

    @Transactional
    void deleteById(Integer id);

    List<User> findByEmail (String email);

    //List<User> findByPassword (String password);

}
