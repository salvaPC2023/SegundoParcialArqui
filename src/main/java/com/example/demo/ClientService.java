package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ApiClient apiClient;

    public ClientService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ClientResponseDto createClient(ClientRequestDto requestDto) {
        boolean success = apiClient.createClient(requestDto);
        if (success) {
            return new ClientResponseDto(true, "Client created successfully.");
        } else {
            return new ClientResponseDto(false, "Client already exists.");
        }
    }
}
