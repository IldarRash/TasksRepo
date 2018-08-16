package com.example.demo.services;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.Task;
import com.example.demo.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    private final static String STATUS_CREATED = "created";
    private final static String STATUS_RUNNIG = "running";
    private final static String STATUS_DONE = "done";
    private final Long TWO_MIN = 2*60*1000L;

    @Autowired
    private TaskRepo taskRepo;

    public UUID createTask() {
        Task task = new Task();
        task.setTimestamp(System.currentTimeMillis());
        task.setStatus(STATUS_CREATED);
        taskRepo.save(task);

        return task.getId();
    }

    public Task getTask(UUID id) throws NotFoundException {
        return taskRepo.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    @Scheduled(fixedDelay = 1000)
    private void updateTasks() {
        List<Task> tasks = taskRepo.findAllByStatus(STATUS_RUNNIG);
        if(tasks.size() != 0) {
            for (Task task : tasks) {
                if(System.currentTimeMillis() - task.getTimestamp() >= TWO_MIN) {
                    task.setStatus(STATUS_DONE);
                    task.setTimestamp(System.currentTimeMillis());
                    taskRepo.save(task);
                }
            }
        }
    }

}
