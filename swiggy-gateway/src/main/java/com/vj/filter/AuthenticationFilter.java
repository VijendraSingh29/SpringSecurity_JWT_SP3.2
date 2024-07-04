package com.vj.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    @Autowired
    RestTemplate restTemplate ;
    @Autowired
    RouteValidator routeValidator ;

    @Autowired
    JwtService jwtService ;
    public AuthenticationFilter()
    {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {

            // if routes is by pass or need to apply the security on that
            if (routeValidator.isSecured.test(exchange.getRequest())) {
                //header contains token or not
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new RuntimeException("missing authorization header");
                }

                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);

                if(authHeader!=null && authHeader.startsWith("Bearer "))
                {
                    String token = authHeader.substring(7);

                   // restTemplate.getForObject("http://IDENTITY-SERVICE/auth/validateToken?token=" +token,String.class);

                    jwtService.validateToken(token);
                }

            }
            return chain.filter(exchange);
        }) ;
    }
    public static class Config {

    }
}
