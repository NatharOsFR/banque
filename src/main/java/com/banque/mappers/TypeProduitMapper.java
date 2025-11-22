package com.banque.mappers;

import com.banque.dataTransferObjects.TypeProduitDto;
import com.banque.model.TypeProduit;

public class TypeProduitMapper {

    public static TypeProduitDto toDto(TypeProduit typeProduit) {
        if(typeProduit == null) return null;

        return new TypeProduitDto(
                typeProduit.getId(),
                typeProduit.getIntitule(),
                typeProduit.getCotisationCarte(),
                typeProduit.getTauxInteretAgios()
        );
    }

    public static TypeProduit toEntity(TypeProduitDto dto) {
        if(dto == null) return null;
        TypeProduit type = new TypeProduit();
        type.setId(dto.getId());
        type.setIntitule(dto.getIntitule());
        type.setCotisationCarte(dto.getCotisationCarte());
        type.setTauxInteretAgios(dto.getTauxInteretAgios());
        return type;
    }
}
