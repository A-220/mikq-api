package com.qst.mikq.service;

import com.qst.mikq.enums.PrioritiesOfTask;
import com.qst.mikq.exception.NotFoundException;
import com.qst.mikq.exception.ValidationException;
import com.qst.mikq.model.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        if (!mapOfTasks.containsKey(id)) {
            throw new NotFoundException(String.format(TASK_NOT_FOUND, id));
        }

        return mapOfTasks.get(id);
    }

    public List<Task> getTaskByClosed(Boolean closed) {
        return mapOfTasks.values().stream()
                .filter(task -> task.getClosed().equals(closed))
                .collect(Collectors.toList());
    }

    public List<Task> getTaskByPriority(PrioritiesOfTask priority) {
        return mapOfTasks.values().stream()
                .filter(task -> task.getPriority().equals(priority))
                .collect(Collectors.toList());
    }

    public Task createTask(Task task) {
        mapOfTasks.put(task.getId(), task);
        log.info(SUCCESSFULLY_CREATE_TASK, task.getName());
        return task;
    }

    public Task deleteTask(Long id) {
        if (!mapOfTasks.containsKey(id)) { // стоит ли вынести проверку в отдельный метод,
            // она юзается в трех местах уже сейчас
            throw new NotFoundException(String.format(TASK_NOT_FOUND, id));
        }

        var task = mapOfTasks.get(id); // вот это потом удалить, сейчас возвращаю таску
        mapOfTasks.remove(id);
        log.info(SUCCESSFULLY_DELETE_TASK, id);
        return task;
    }

    public Task updateTask(Task task) {
        if (!mapOfTasks.containsKey(task.getId())) {
            throw new NotFoundException(String.format(TASK_NOT_FOUND, task.getId()));
        }

        mapOfTasks.put(task.getId(), task);
        log.info(SUCCESSFULLY_UPDATE_TASK, task.getId());
        return task;
    }


    // Вот тут нунжно будет очень хорошо подумать читай Reflection Api в java
    // Тут если что прям страшилка которая в ран тайме получает обьект и меняет его приватные поля без сеттеров лол
    // Уверен можно сделать как то по умному, но это просто прикольно
    public Task updateTaskPartially(Long id, Map<String, Object> paramsMap)  {
        if (!mapOfTasks.containsKey(id)) {
            throw new NotFoundException(String.format(TASK_NOT_FOUND, id));
        }

        var task = mapOfTasks.get(id);

        Field[] fields = task.getClass().getDeclaredFields();
        for (Map.Entry<String, Object> param : paramsMap.entrySet()) {
            for(Field field : fields) {
                if(param.getKey().equalsIgnoreCase(field.getName())) {
                    field.setAccessible(true);
                    try {
                        field.set(task, param.getValue());
                        // TODO: 11.12.2023 think about validation of param.getValue();
                    } catch (IllegalAccessException e) {
                        throw new ValidationException(e.getMessage());
                    }
                }
            }
        }
        return task;
    }

    public Task updateExperience(Long id, Integer experience) {
        if(!mapOfTasks.containsKey(id)) {
            throw new NotFoundException(String.format(TASK_NOT_FOUND, id));
        }

        if(experience <= 0) {
            throw new ValidationException("Experience cannot be less than zero");
        }

        var task = mapOfTasks.get(id);
        task.setExperience(experience);
        log.info("buba");

        return task;
    }




}
