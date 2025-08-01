package edu.chibao.identity.repository.httpclient;

import edu.chibao.identity.dto.request.UserProfileCreationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "profile-service", url = "${app.service.profile}")
public interface ProfileClient {
    // when call to this function open feign will make a call with post method, requestUrl = url + /users
    // and return Content-type: Application/json
    @PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    Object createUserProfile(@RequestBody UserProfileCreationRequest request);

}
