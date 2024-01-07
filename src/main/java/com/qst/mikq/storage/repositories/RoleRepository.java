package com.qst.mikq.storage.repositories;

import com.qst.mikq.storage.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
