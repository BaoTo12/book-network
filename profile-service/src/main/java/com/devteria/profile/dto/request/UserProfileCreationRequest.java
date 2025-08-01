package com.devteria.profile.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileCreationRequest {
    String userId;
    String firstName;
    String lassName;
    LocalDate dob;
    String city;
}
