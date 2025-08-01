package com.devteria.profile.dto.response;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class UserProfileResponse {
    String id;
    String firstName;
    String lassName;
    LocalDate dob;
    String city;
}
