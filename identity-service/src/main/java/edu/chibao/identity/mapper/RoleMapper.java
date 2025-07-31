package edu.chibao.identity.mapper;

import edu.chibao.identity.dto.request.RoleRequest;
import edu.chibao.identity.dto.response.RoleResponse;
import edu.chibao.identity.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;



@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
