package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClientServiceTest {

    private ApiClient apiClient;
    private ClientService clientService;

    @BeforeEach
    void setUp() {
        apiClient = Mockito.mock(ApiClient.class);
        clientService = new ClientService(apiClient);
    }

    @Test
    void createClientSuccess() {
        ClientRequestDto requestDto = new ClientRequestDto("John", "Doe", "Smith", "12345678");
        when(apiClient.createClient(requestDto)).thenReturn(true);

        ClientResponseDto response = clientService.createClient(requestDto);
        assertTrue(response.success());
        assertEquals("Client created successfully.", response.message());
        verify(apiClient).createClient(requestDto);
    }

    @Test
    void createClientAlreadyExists() {
        ClientRequestDto requestDto = new ClientRequestDto("John", "Doe", "Smith", "12345678");
        when(apiClient.createClient(requestDto)).thenReturn(false);

        ClientResponseDto response = clientService.createClient(requestDto);
        assertFalse(response.success());
        assertEquals("Client already exists.", response.message());
        verify(apiClient).createClient(requestDto);
    }
}
