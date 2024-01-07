package com.qst.mikq.api.factories;

import com.qst.mikq.api.dto.RoleDto;
import com.qst.mikq.storage.entity.RoleEntity;
import org.springframework.stereotype.Component;

@Component
public class RoleDtoFactory {

    public RoleDto makeRoleDto(RoleEntity roleEntity) {
        return RoleDto.builder()
                .id(roleEntity.getId())
                .name(roleEntity.getNameOfRole())
                .build();
    }
}
