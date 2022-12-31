package com.example.app.service;

import com.example.app.repository.ClientRepository;
import com.example.app.domain.Client;
import com.example.app.domain.dto.ClientDTO;
import com.example.core.StandardUploadFile;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService implements StandardUploadFile<Client> {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void save(Client entity) {
        this.clientRepository.save(entity);
    }

    @Override
    public void save(Client entity, String fileDB) {
        entity.setFile(fileDB);
        this.clientRepository.save(entity);
    }
}