package com.example.todo.repositories;

import com.example.todo.models.UserRecords;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserRecords,Long> {
}
