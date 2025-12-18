package com.example.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.todo.models.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
