package com.example.demo.service;

import java.time.Instant;

import org.springframework.resilience.annotation.Retryable;
import org.springframework.stereotype.Service;

import com.example.demo.client.ExternalProvisionClient;

@Service
public class ProvisionService {

    private final ExternalProvisionClient externalClient;

    public ProvisionService(ExternalProvisionClient externalClient) {
        this.externalClient = externalClient;
    }

    @Retryable(maxRetries = 5, delay = 100)
    public String provision(String id) {
        String r = externalClient.callProvisionApi(id);
        return "provisioned:" + id + "@" + Instant.now();
    }
}
