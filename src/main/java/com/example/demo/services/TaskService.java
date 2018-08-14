package com.example.demo.services;

import com.example.demo.model.Task;
import com.example.demo.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TaskService {

    private final static String STATUS_CREATED = "created";
    private final static String STATUS_RUNNIG = "running";
    private final static String STATUS_COMPLETED = "completed";

    @Autowired
    private TaskRepo taskRepo;

    public UUID createTask() {
        Task task = new Task();
        task.setTimestamp(System.currentTimeMillis());
        task.setStatus(STATUS_CREATED);
        taskRepo.save(task);

        return task.getId();
    }

    public Task getTask(UUID id) throws ChangeSetPersister.NotFoundException {
        return taskRepo.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}
