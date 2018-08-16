package com.example.demo.controller;

import com.example.demo.exceptions.GuidException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.Task;
import com.example.demo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public UUID createdTask() {
        return taskService.createTask();
    }


    @GetMapping(value = "/{id}")
    public Task getTask(@PathVariable("id") String id) throws NotFoundException {
        UUID uuid = validate(id);
        return taskService.getTask(uuid);
    }

    private UUID validate(String id) {
        try {
            UUID uuid = UUID.fromString(id);
            return uuid;
        } catch (IllegalArgumentException ex) {
            throw new GuidException("Это не GUID");
        }
    }
}
