package com.qst.mikq.storage.repositories;

import com.qst.mikq.storage.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
