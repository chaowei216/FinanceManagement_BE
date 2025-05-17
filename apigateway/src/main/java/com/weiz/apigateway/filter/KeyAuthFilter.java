package com.weiz.apigateway.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class KeyAuthFilter extends AbstractGatewayFilterFactory<KeyAuthFilter.Config> {

    @Value("${apiKey}")
    private String apiKey;

    public KeyAuthFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(KeyAuthFilter.Config config) {

        return (exchange, chain) -> {
          if (!exchange.getRequest().getHeaders().containsKey("apiKey")) {
            throw new RuntimeException("Missing authorization information");
          }

          System.out.println(apiKey);

          String key = exchange.getRequest().getHeaders().getFirst("apiKey");

            assert key != null;
            if (!key.equals(apiKey)) {
              throw new RuntimeException("wrong authorization information");
          }

          ServerHttpRequest request = exchange.getRequest();
          return chain.filter(exchange.mutate().request(request).build());
        };
    }

    public static class Config {

    }
}
