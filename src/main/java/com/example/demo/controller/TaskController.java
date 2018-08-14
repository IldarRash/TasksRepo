package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public UUID createdTask() {
        return taskService.createTask();
    }


    @GetMapping(value = "/{guid}")
    public Task getTask(@PathVariable("guid") UUID id) throws ChangeSetPersister.NotFoundException {
        return taskService.getTask(id);
    }
}
