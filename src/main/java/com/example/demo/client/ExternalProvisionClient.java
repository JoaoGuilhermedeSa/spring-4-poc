package com.example.demo.client;

import org.springframework.resilience.annotation.ConcurrencyLimit;
import org.springframework.resilience.annotation.Retryable;
import org.springframework.stereotype.Component;

@Component
public class ExternalProvisionClient {

    private final ProvisionClient provisionClient;

    public ExternalProvisionClient(ProvisionClient provisionClient) {
        this.provisionClient = provisionClient;
    }

    @Retryable(maxRetries = 3, delay = 2000)
    @ConcurrencyLimit(10)
    public String callProvisionApi(String id) {
        try {
            return provisionClient.callProvisionApi(id);
        } catch (Exception ex) {
            throw new RuntimeException("External call failed: " + ex.getMessage(), ex);
        }
    }
}
