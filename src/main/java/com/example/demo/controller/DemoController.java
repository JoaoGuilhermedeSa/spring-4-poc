package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ProvisionService;

@RestController
@RequestMapping("/api")
public class DemoController {

    private final ProvisionService provisionService;

    public DemoController(ProvisionService provisionService) {
        this.provisionService = provisionService;
    }

    @GetMapping("/v1/provision/{id}")
    public ResponseEntity<String> provisionV1(@PathVariable String id) {
        String result = provisionService.provision(id);
        return ResponseEntity.ok("v1: " + result);
    }


}
