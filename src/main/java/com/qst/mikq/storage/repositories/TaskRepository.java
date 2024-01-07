package com.qst.mikq.storage.repositories;

import com.qst.mikq.storage.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
