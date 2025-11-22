package com.banque.mappers;

import com.banque.dataTransferObjects.ClientBancaireDto;
import com.banque.model.ClientBancaire;

public class ClientBancaireMapper {

    public static ClientBancaireDto toDto(ClientBancaire client) {
        if (client == null) return null;
        ClientBancaireDto dto = new ClientBancaireDto();
        dto.setId(client.getId());
        client.getPersonnes().forEach(p -> dto.addPersonne(PersonneMapper.toDto(p)));
        return dto;
    }

    public static ClientBancaire toEntity(ClientBancaireDto dto) {
        if (dto == null) return null;
        ClientBancaire client = new ClientBancaire();
        client.setId(dto.getId());
        dto.getPersonnesDtos().forEach(p -> client.addPersonne(PersonneMapper.toEntity(p)));
        return client;
    }
}
