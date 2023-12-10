package com.qst.mikq.controller;

import com.qst.mikq.model.Task;
import com.qst.mikq.service.TaskControllerService;
import com.qst.mikq.util.ErrorHandlerUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskControllerService taskControllerService;

    @Autowired
    public TaskController(TaskControllerService taskControllerService) {
        this.taskControllerService = taskControllerService;
    }

    @GetMapping
    public Collection<Task> getAllTasks() {
        return taskControllerService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable(value = "id") Long id) {
        return taskControllerService.getTask(id);
    }

    @PostMapping
    public Task createTask(@Valid @RequestBody Task task, BindingResult bindingResult) {
        ErrorHandlerUtil.throwValidationExceptionIfErrorsExist(bindingResult);
        return taskControllerService.createTask(task);
    }

    @PostMapping("/{id}")
    public Task deleteTask(@PathVariable(value = "id") Long id) {
        return taskControllerService.deleteTask(id);
    }

    @PutMapping
    public Task updateTask(@Valid @RequestBody Task task, BindingResult bindingResult) {
        ErrorHandlerUtil.throwValidationExceptionIfErrorsExist(bindingResult);
        return taskControllerService.updateTask(task);
    }

}
