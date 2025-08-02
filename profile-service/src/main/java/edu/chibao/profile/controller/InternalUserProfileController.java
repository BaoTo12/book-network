package edu.chibao.profile.controller;

import edu.chibao.profile.dto.request.UserProfileCreationRequest;
import edu.chibao.profile.dto.response.UserProfileResponse;
import edu.chibao.profile.service.UserProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class InternalUserProfileController {
    UserProfileService userProfileService;

    @PostMapping("/internal/users")
    public UserProfileResponse createUserProfile(@RequestBody UserProfileCreationRequest request){
        return userProfileService.createUserProfile(request);
    }

}
