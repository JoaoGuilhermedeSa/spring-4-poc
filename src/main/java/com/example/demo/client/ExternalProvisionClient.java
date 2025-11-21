package com.example.demo.client;

import org.springframework.resilience.annotation.ConcurrencyLimit;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ExternalProvisionClient {

    private final RestTemplate restTemplate;

    public ExternalProvisionClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @ConcurrencyLimit(10)
    public String callProvisionApi(String id) {
        try {
            return restTemplate.getForObject("https://example-provision-service.local/external/provision/{id}", String.class, id);
        } catch (Exception ex) {
            throw new RuntimeException("External call failed: " + ex.getMessage(), ex);
        }
    }
}
