package com.example.rest;

import com.example.domain.Client;
import com.example.domain.dto.ClientDTO;
import com.example.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping( "/clients")
public class ClientRest {
    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> insert(ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.insert(clientDTO));
    }
}
