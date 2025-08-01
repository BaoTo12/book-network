package edu.chibao.api_gateway.service;

import edu.chibao.api_gateway.dto.ApiResponse;
import edu.chibao.api_gateway.dto.request.IntrospectRequest;
import edu.chibao.api_gateway.dto.response.IntrospectResponse;
import edu.chibao.api_gateway.repo.IdentityClient;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class IdentityService {

    IdentityClient identityClient;


    public Mono<ApiResponse<IntrospectResponse>> introspect(String token) {
        var request = IntrospectRequest.builder()
                .token(token)
                .build();
        return identityClient.introspect(request);
    }
}
