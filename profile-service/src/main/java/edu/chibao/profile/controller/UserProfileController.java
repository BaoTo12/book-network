package edu.chibao.profile.controller;

import edu.chibao.profile.dto.ApiResponse;
import edu.chibao.profile.dto.response.UserProfileResponse;
import edu.chibao.profile.service.UserProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserProfileController {
    UserProfileService userProfileService;


    @GetMapping("/users/{profileId}")
    public UserProfileResponse getUserProfileById(@PathVariable String profileId){
        return userProfileService.getUserProfileById(profileId);
    }

    @GetMapping("/users")
    public ApiResponse<List<UserProfileResponse>> getAllProfiles(){
        return ApiResponse.<List<UserProfileResponse>>builder()
                .result(userProfileService.getAllProfiles())
                .build();
    }
}
