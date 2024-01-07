package com.qst.mikq.api.factories;

import com.qst.mikq.api.dto.TeamDto;
import com.qst.mikq.storage.entity.TeamEntity;
import org.springframework.stereotype.Component;

@Component
public class TeamDtoFactory {
   public TeamDto makeDto(TeamEntity teamEntity) {
       return TeamDto.builder()
               .id(teamEntity.getId())
               .name(teamEntity.getName())
               .build()
   }
}
