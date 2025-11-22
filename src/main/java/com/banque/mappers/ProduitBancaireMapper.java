package com.banque.mappers;
import com.banque.dataTransferObjects.OperationDto;
import com.banque.dataTransferObjects.ProduitBancaireDto;
import com.banque.model.Operation;
import com.banque.model.ProduitBancaire;

import java.util.Set;
import java.util.stream.Collectors;

public class ProduitBancaireMapper {
    public static ProduitBancaireDto toDto(ProduitBancaire produit) {
        if (produit == null) { return null; }
        ProduitBancaireDto dto = new ProduitBancaireDto();
        dto.setId(produit.getId());
        dto.setNumeroCompte(produit.getNumeroCompte());
        dto.setSoldeCourant(produit.getSolde_courant());
        dto.setTypeProduitDto(TypeProduitMapper.toDto(produit.getTypeProduit()));
        dto.setClientBancaireDto(ClientBancaireMapper.toDto(produit.getClientBancaire()));

        Set<OperationDto> ops = produit.getOperations().stream()
                .map(OperationMapper::toDto)
                .collect(Collectors.toSet());
        dto.setOperationDtos(ops);
        return dto;
    }

    public static ProduitBancaire toEntity(ProduitBancaireDto dto) {
        if (dto == null) { return null; }

        ProduitBancaire produit = new ProduitBancaire();
        produit.setId(dto.getId());
        produit.setNumeroCompte(dto.getNumeroCompte());
        produit.setSolde_courant(dto.getSoldeCourant());
        produit.setTypeProduit(TypeProduitMapper.toEntity(dto.getTypeProduitDto()));
        produit.setClientBancaire(ClientBancaireMapper.toEntity(dto.getClientBancaireDto()));

        Set<Operation> ops = dto.getOperationDtos().stream()
                .map(OperationMapper::toEntity)
                .collect(Collectors.toSet());
        produit.setOperations(ops);

        return produit;
    }
}
