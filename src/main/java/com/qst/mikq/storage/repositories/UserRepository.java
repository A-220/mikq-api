package com.qst.mikq.storage.repositories;

import com.qst.mikq.storage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
