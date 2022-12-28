package com.example.service;

import com.example.domain.Client;
import com.example.domain.dto.ClientDTO;
import com.example.domain.FileDB;
import com.example.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientService {

    private final ClientRepository clientRepository;
    private ModelMapper modelMapper;

    public Client insert(ClientDTO clientDTO) {
        List<MultipartFile> files = clientDTO.getMultipartFile();
        List<FileDB> filesDB = files.stream().map(file -> {
            try {
                String fileName = StringUtils.cleanPath(file.getOriginalFilename());
                return new FileDB(fileName, file.getContentType(), file.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
        Client client = modelMapper.map(clientDTO, Client.class);
        client.setFiles(filesDB);
        return clientRepository.save(client);
    }
}
