package edu.chibao.profile.mapper;

import edu.chibao.profile.dto.request.UserProfileCreationRequest;
import edu.chibao.profile.dto.response.UserProfileResponse;
import edu.chibao.profile.entity.UserProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfile toUserProfile(UserProfileCreationRequest request);
    UserProfileResponse toUserProfileResponse(UserProfile userProfile);
}
