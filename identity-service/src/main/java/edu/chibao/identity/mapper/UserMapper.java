package edu.chibao.identity.mapper;

import edu.chibao.identity.dto.request.UserCreationRequest;
import edu.chibao.identity.dto.request.UserUpdateRequest;
import edu.chibao.identity.dto.response.UserResponse;
import edu.chibao.identity.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;



@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
