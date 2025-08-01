package com.devteria.profile.service;


import com.devteria.profile.dto.request.UserProfileCreationRequest;
import com.devteria.profile.dto.response.UserProfileResponse;
import com.devteria.profile.entity.UserProfile;
import com.devteria.profile.mapper.UserProfileMapper;
import com.devteria.profile.repo.UserProfileRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

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
}
