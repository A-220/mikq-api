package com.qst.mikq.controller;

import com.qst.mikq.enums.PrioritiesOfTask;
import com.qst.mikq.model.Task;
import com.qst.mikq.service.TaskControllerService;
import com.qst.mikq.util.ErrorHandlerUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskControllerService taskControllerService;

    // Читай IoC контейнеры
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

    @GetMapping
    public List<Task> getTaskByClosed(@RequestParam(value = "closed", defaultValue = "false") Boolean closed) {
        // TODO: 11.12.2023 Change closed to status
        return taskControllerService.getTaskByClosed(closed);
    }

    @GetMapping
    public List<Task> getTaskByPriority(@RequestParam(value = "priority", defaultValue = "IMPORTANT") PrioritiesOfTask priority) {
        return taskControllerService.getTaskByPriority(priority);
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

    @PatchMapping("/{id}")
    public Task updateTask(@PathVariable(value = "id") Long id,
                           @RequestBody Map<String, Object> paramsMap) {
        return taskControllerService.updateTaskPartially(id, paramsMap);
    }

    @PatchMapping("/{id}/experience")
    public Task updateExperience(@PathVariable(value = "id") Long id,
                                 @RequestBody Integer experience) {
        return taskControllerService.updateExperience(id, experience);
    }

}
