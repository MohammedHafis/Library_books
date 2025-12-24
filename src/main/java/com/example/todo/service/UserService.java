package com.example.todo.service;

import com.example.todo.models.UserRecords;
import com.example.todo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void userCreation(UserRecords user) {
        userRepository.save(user);
    }

    public List<UserRecords> listUser() {
        return userRepository.findAll();
    }
}
