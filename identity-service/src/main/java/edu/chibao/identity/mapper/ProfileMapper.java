package edu.chibao.identity.mapper;

import edu.chibao.identity.dto.request.UserCreationRequest;
import edu.chibao.identity.dto.request.UserProfileCreationRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    UserProfileCreationRequest toUserProfileCreationRequest(UserCreationRequest request);
}
