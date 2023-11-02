package com.springsecutiry.fiap.modules.user.request;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class UserRoleRequest {
    private UUID userId;
    private List<UUID> listRoles;
}
