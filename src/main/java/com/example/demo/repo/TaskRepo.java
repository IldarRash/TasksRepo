package com.example.demo.repo;

import com.example.demo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TaskRepo extends JpaRepository<Task, UUID> {

    List<Task> findAllByStatus(String status);
}
