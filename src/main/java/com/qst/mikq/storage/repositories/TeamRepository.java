package com.qst.mikq.storage.repositories;

import com.qst.mikq.storage.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<TeamEntity, Long> {
}
