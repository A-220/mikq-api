package com.qst.mikq.service;

import com.qst.mikq.exception.NotFoundException;
import com.qst.mikq.model.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class TaskControllerService {
    private final Map<Long, Task> mapOfTasks = new HashMap<>();
    // TODO: 10.12.2023 Заменить на sql
    public static final String SUCCESSFULLY_CREATE_TASK = "Task with id: {}, correctly added to data!";
    public static final String SUCCESSFULLY_DELETE_TASK = "Task with id: {}, correctly deleted from data!";
    public static final String SUCCESSFULLY_UPDATE_TASK = "Task with id: {}, correctly updated!";
    public static final String TASK_NOT_FOUND = "Task with id: %s doesn't exist";

    public Collection<Task> getAllTasks() {
        return mapOfTasks.values();
    }

    public Task getTask(Long id) {
        if(!mapOfTasks.containsKey(id)) {
            throw new NotFoundException(String.format(TASK_NOT_FOUND, id));
        }

        return mapOfTasks.get(id);
    }

    public Task createTask(Task task) {
        mapOfTasks.put(task.getId(), task);
        log.info(SUCCESSFULLY_CREATE_TASK, task.getName());
        return task;
    }

    public Task deleteTask(Long id) {
        if(!mapOfTasks.containsKey(id)) { // стоит ли вынести проверку в отдельный метод,
            // она юзается в трех местах уже сейчас
            throw new NotFoundException(String.format(TASK_NOT_FOUND, id));
        }

        var task = mapOfTasks.get(id); // вот это потом удалить, сейчас возвращаю таску
        mapOfTasks.remove(id);
        log.info(SUCCESSFULLY_DELETE_TASK, id);
        return task;
    }

    public Task updateTask(Task task) {
        if(!mapOfTasks.containsKey(task.getId())) {
            throw new NotFoundException(String.format(TASK_NOT_FOUND, task.getId()));
        }

        mapOfTasks.put(task.getId(), task);
        log.info(SUCCESSFULLY_UPDATE_TASK, task.getId());
        return task;
    }



}
