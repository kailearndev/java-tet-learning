package com.hello.hello_kai_jva.service;

import com.hello.hello_kai_jva.dto.request.UserCreationRequest;
import com.hello.hello_kai_jva.dto.request.UserUpdateRequest;
import com.hello.hello_kai_jva.entity.User;
import com.hello.hello_kai_jva.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setName(request.getName());
        user.setCreatedAt(request.getCreatedAt());
       return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(String userId,UserUpdateRequest request) {
        User user =  getUserById(userId);
        user.setPassword(request.getPassword());
        user.setName(request.getName());
        user.setCreatedAt(request.getCreatedAt());

       return userRepository.save(user);
    }

    public void deleteUser(String userId) {
         userRepository.deleteById(userId);
    }
}
