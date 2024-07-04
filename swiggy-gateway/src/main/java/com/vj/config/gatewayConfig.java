package com.vj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class gatewayConfig {

    @Bean
    RestTemplate restTemplate()
    {
        return new RestTemplate() ;
    }
}
