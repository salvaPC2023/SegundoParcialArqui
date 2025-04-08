package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/create")
    public ClientResponseDto createClient(@RequestBody ClientRequestDto clientRequestDto) {
        return clientService.createClient(clientRequestDto);
    }
}
