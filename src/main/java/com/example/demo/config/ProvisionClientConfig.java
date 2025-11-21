package com.example.demo.config;

import com.example.demo.client.ProvisionClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ProvisionClientConfig {

    @Bean
    public ProvisionClient provisionClient() {
        WebClient webClient = WebClient.builder()
                .baseUrl("https://example-provision-service.local/external")
                .build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(WebClientAdapter.create(webClient)).build();
        return factory.createClient(ProvisionClient.class);
    }
}
