package com.example.APIRest.controllers;
import com.example.APIRest.models.TaskModel;
import com.example.APIRest.services.TasksServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

@RestController
// Se define la ruta
@RequestMapping("/api/tasks")
public class TasksControllers {
    @Autowired
    private TasksServices tasksServices;

    @GetMapping
    public ArrayList<TaskModel> getTasks() {
        return this.tasksServices.bringTasks();
    }

    // Optional puede devolver o no algo
    @GetMapping(path = "/{id}")
    public Optional<TaskModel> getTask(@PathVariable Long id) {
        return this.tasksServices.bringTask(id);
    }

    @PostMapping
    public TaskModel createTask(@RequestBody TaskModel task) {
        return this.tasksServices.saveTask(task);
    }

    @PatchMapping(path = "/{id}")
    public TaskModel updateTask(@RequestBody TaskModel request, @PathVariable("id") Long id) {
        return this.tasksServices.updTask(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public Boolean deleteTask(@PathVariable("id") Long id) {
        return this.tasksServices.delTask(id);
    }
}
