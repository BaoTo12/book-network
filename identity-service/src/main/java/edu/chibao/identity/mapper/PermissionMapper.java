package edu.chibao.identity.mapper;

import edu.chibao.identity.dto.request.PermissionRequest;
import edu.chibao.identity.dto.response.PermissionResponse;
import edu.chibao.identity.entity.Permission;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
