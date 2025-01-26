package com.hello.hello_kai_jva.controller;

import com.hello.hello_kai_jva.dto.request.UserCreationRequest;
import com.hello.hello_kai_jva.dto.request.UserUpdateRequest;
import com.hello.hello_kai_jva.entity.User;
import com.hello.hello_kai_jva.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    User createUser(@RequestBody UserCreationRequest user) {
       return userService.createUser(user);

    }
    @GetMapping
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{userId}")
    User getUserId(@PathVariable String userId) {
    return  userService.getUserById(userId);
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable String userId , @RequestBody UserUpdateRequest request) {
        return  userService.updateUser(userId, request);
    }
    @DeleteMapping("/{userId}")
    void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }
}
