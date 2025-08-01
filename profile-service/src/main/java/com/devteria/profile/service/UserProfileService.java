package com.devteria.profile.service;


import com.devteria.profile.dto.request.UserProfileCreationRequest;
import com.devteria.profile.dto.response.UserProfileResponse;
import com.devteria.profile.entity.UserProfile;
import com.devteria.profile.mapper.UserProfileMapper;
import com.devteria.profile.repo.UserProfileRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Transactional
public class UserProfileService {
    UserProfileRepository userProfileRepository;
    UserProfileMapper mapper;

    public UserProfileResponse createUserProfile(UserProfileCreationRequest request) {
        UserProfile userProfile = mapper.toUserProfile(request);
        userProfile = userProfileRepository.save(userProfile);
        return mapper.toUserProfileResponse(userProfile);
    }

    @Transactional(readOnly = true)
    public UserProfileResponse getUserProfileById(String id){
        UserProfile userProfile = userProfileRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Profile not found with " + id)
        );

        return mapper.toUserProfileResponse(userProfile);
    }
}
