package com.example.rest;

import com.example.domain.Client;
import com.example.domain.dto.ClientDTO;
import com.example.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/clients")
public class ClientRest {
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> insert(ClientDTO clientDTO) throws IOException {
        return ResponseEntity.ok(clientService.insert(clientDTO));
    }
}
