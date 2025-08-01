package edu.chibao.api_gateway.cconfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;


@Component
@Slf4j
public class AuthenticationFilter implements GlobalFilter, Ordered {


    // ServerWebExchange is a reactive equivalent of HttpServletRequest/Response combined. It encapsulates:
    /*
    *   1. The HTTP request (getRequest())
    *   2. The HTTP response (getResponse())
        3. Session information
      * 4. Request attributes
     * */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("Enter Global Filter for Authentication ...");
        // Get Token
        List<String> authHeaders = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION);
        if (CollectionUtils.isEmpty(authHeaders))
            return unauthenticated(exchange.getResponse());
        // Verify token
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }

    // ServerHttpResponse is reactive HTTP response object in Spring WebFlux
    // it provides
    /*
     * 1. Set status codes (setStatusCode())
     * 2. Write response body (writeWith())
     * 3. Add headers
     * 4. Access buffer factory for creating response data
     * */
    Mono<Void> unauthenticated(ServerHttpResponse response) {
        String msg = "You are not authenticated";
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        return response.writeWith(Mono.just(response.bufferFactory().wrap(msg.getBytes())));
    }
}
