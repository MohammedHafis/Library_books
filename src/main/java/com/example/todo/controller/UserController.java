package com.example.todo.controller;

import com.example.todo.models.UserRecords;
import com.example.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<String> userCreation(@RequestBody UserRecords user){
        userService.userCreation(user);
        return ResponseEntity.ok("Created Successfully");
    }

    @GetMapping("/listUser")
    public ResponseEntity<List<UserRecords>> getUsers(){
        return ResponseEntity.ok(userService.listUser());
    }
}
