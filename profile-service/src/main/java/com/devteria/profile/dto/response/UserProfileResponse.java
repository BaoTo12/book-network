package com.devteria.profile.dto.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileResponse {
    String id;
    String firstName;
    String lassName;
    LocalDate dob;
    String city;
}
