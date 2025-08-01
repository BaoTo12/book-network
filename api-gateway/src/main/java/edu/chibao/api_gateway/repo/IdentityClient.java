package edu.chibao.api_gateway.repo;

import edu.chibao.api_gateway.dto.ApiResponse;
import edu.chibao.api_gateway.dto.request.IntrospectRequest;
import edu.chibao.api_gateway.dto.response.IntrospectResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

public interface IdentityClient {
    @PostExchange(url = "/auth/introspect", contentType = MediaType.APPLICATION_JSON_VALUE)
    Mono<ApiResponse<IntrospectResponse>> introspect(@RequestBody IntrospectRequest request);
}
// Mono is a reactive type from Project Reactor representing an asynchronous sequence that emits 0 or 1 item, then completes or errors.
// Lazy Evaluation: Nothing executes until you subscribe
// Non-blocking: Operations don't block threads
// Composable: Chain operations functionally
/*
* Creation:

Mono.just(value) - Emit single value
Mono.empty() - Complete without emitting
Mono.error(throwable) - Emit error
Mono.fromCallable(() -> computation)

Transformation:

map(Function) - Transform the item
flatMap(Function) - Transform to another Mono and flatten
filter(Predicate) - Conditionally emit

Combination:

zipWith(other) - Combine with another Mono
then(other) - Ignore result, continue with other

Terminal Operations:

subscribe() - Trigger execution
block() - Synchronously wait (avoid in reactive code)
*
* */