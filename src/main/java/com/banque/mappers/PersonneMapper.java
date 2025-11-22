package com.banque.mappers;

import com.banque.dataTransferObjects.PersonneDto;
import com.banque.model.Personne;
import com.banque.model.PersonneMorale;
import com.banque.model.PersonnePhysique;

public class PersonneMapper {

    public static PersonneDto toDto(Personne personne) {
       if (personne == null) return null;

       PersonneDto dto = new PersonneDto();
        dto.setId(personne.getId());
        dto.setAdresse(personne.getAdresse());

        if (personne instanceof PersonnePhysique physique) {
            dto.setNom(physique.getNom());
            dto.setTypePersonne("PHYSIQUE");
        } else if (personne instanceof PersonneMorale morale) {
            dto.setNom(morale.getRaisonSociale());
            dto.setTypePersonne("MORALE");
        }
        return dto;
    }

    public static Personne toEntity(PersonneDto dto) {
        if(dto == null) return null;

        if("PHYSIQUE".equalsIgnoreCase(dto.getTypePersonne())) {
            PersonnePhysique p = new PersonnePhysique();
            p.setId(dto.getId());
            p.setAdresse(dto.getAdresse());
            p.setNom(dto.getNom());
            return p;
        } else if ("MORALE".equalsIgnoreCase(dto.getTypePersonne())) {
            PersonneMorale m = new PersonneMorale();
            m.setId(dto.getId());
            m.setAdresse(dto.getAdresse());
            m.setRaisonSociale(dto.getNom());
            return m;
        }

        return null;
    }
}
