package com.example.demo.client;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("https://example-provision-service.local/external")
public interface ProvisionClient {

    @GetExchange("/provision/{id}")
    String callProvisionApi(String id);
}
