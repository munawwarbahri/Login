package com.amigoscode.service;

import com.amigoscode.user.User;
import com.amigoscode.repository.UserRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {
        private UserRepository userRepository;
        public UserService(UserRepository userRepository) { this.userRepository = userRepository; }
        public User save(User user) { return userRepository.save(user); }
        public List<User> findAll() { return userRepository.findAll(); }
        public Optional<User> findById(Integer id) { return userRepository.findById(id); }
        public List<User> findByEmail(String email) {return userRepository.findByEmail(email);}
        //public List<User> findByPassword(String password) {return userRepository.findByPassword(password);}
        public void deleteById(Integer id) { userRepository.deleteById(id); }
        public void deleteAll() { userRepository.deleteAll(); }
        public void deleteByUserId(Integer userId) { userRepository.deleteById(userId); }

}


