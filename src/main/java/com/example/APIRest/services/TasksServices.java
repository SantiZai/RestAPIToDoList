package com.example.APIRest.services;
import com.example.APIRest.models.TaskModel;
import com.example.APIRest.repositories.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class TasksServices {
    @Autowired
    ITaskRepository taskRepository;

    public ArrayList<TaskModel> bringTasks() {
        return (ArrayList<TaskModel>) taskRepository.findAll();
    }

    public Optional<TaskModel> bringTask(Long id) {
        return taskRepository.findById(id);
    }

    public TaskModel saveTask(TaskModel task) {
        return taskRepository.save(task);
    }

    public TaskModel updTask(TaskModel request, Long id) {
        Optional<TaskModel> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            TaskModel task = optionalTask.get();
            if (request.getTitle() != null) {
                task.setTitle(request.getTitle());
            }
            if (request.getDescription() != null) {
                task.setDescription(request.getDescription());
            }
            if (request.getLevel() != null) {
                task.setLevel(request.getLevel());
            }
            if (request.getCompleted() != null) {
                task.setCompleted(request.getCompleted());
            }
            return this.taskRepository.save(task);
        } else {
            throw new Error("Task with id: " + id + " not found.");
        }
    }

    public Boolean delTask(Long id) {
        try {
            this.taskRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
