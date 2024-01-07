package com.qst.mikq.storage.repositories;

import com.qst.mikq.storage.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
