package project.apigateway.configuration.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationHeaderFilter extends AbstractGatewayFilterFactory<AuthorizationHeaderFilter.Config> {
    public AuthorizationHeaderFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        // Implement your filter logic here
        return (exchange, chain) -> {
            // Access exchange information or modify it as needed
            ServerHttpRequest request = exchange.getRequest();
            // Modify request headers or perform authorization checks
            // Then proceed with the filter chain
            return chain.filter(exchange);
        };
    }

    public static class Config {
        // You can define configuration properties here if needed
    }
}