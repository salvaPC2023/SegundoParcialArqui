package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ApiClientImpl implements ApiClient {

    private final Set<String> identityDocuments;

    // Simulamos una base de datos usando un Set para almacenar los documentos de identidad
    public ApiClientImpl() {
        identityDocuments = new HashSet<>();
    }

    @Override
    public boolean createClient(ClientRequestDto clientRequestDto) {
        // Verificar si el documento de identidad ya existe
        if (identityDocuments.contains(clientRequestDto.identityDocument())) {
            return false; // El cliente ya existe
        }
        // Simulamos la creación del cliente
        identityDocuments.add(clientRequestDto.identityDocument());
        return true; // Cliente creado exitosamente
    }
}
