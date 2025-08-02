package edu.chibao.profile.service;


import edu.chibao.profile.dto.request.UserProfileCreationRequest;
import edu.chibao.profile.dto.response.UserProfileResponse;
import edu.chibao.profile.entity.UserProfile;
import edu.chibao.profile.mapper.UserProfileMapper;
import edu.chibao.profile.repo.UserProfileRepository;
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
