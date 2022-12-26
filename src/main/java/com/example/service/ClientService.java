package com.example.service;

import com.example.domain.Client;
import com.example.domain.FileDB;
import com.example.domain.dto.ClientDTO;
import com.example.mapper.ClientMapper;
import com.example.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientService {

    private final ClientRepository clientRepository;
    private final FileStorageService fileStorageService;
    private final ClientMapper clientMapper = ClientMapper.INSTANCE;

    public Client insert(ClientDTO clientDTO) throws IOException {
        Optional<MultipartFile> multipartFileOptional = Optional.ofNullable(clientDTO.getMultipartFile());
        FileDB fileDB = null;
        if (multipartFileOptional.isPresent()) fileDB = fileStorageService.store(multipartFileOptional.get());
        clientDTO.setMultipartFile((MultipartFile) fileDB);
        Client client = clientMapper.toModel(clientDTO);
        return clientRepository.save(client);
    }
}
