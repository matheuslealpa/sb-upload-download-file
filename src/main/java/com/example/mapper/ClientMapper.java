package com.example.mapper;

import com.example.domain.Client;
import com.example.domain.dto.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDTO clientToClientDTO(ClientDTO clientDTO);

    Client toModel(ClientDTO clientDTO);
}
