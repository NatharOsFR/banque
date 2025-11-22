package com.banque.dataTransferObjects;

import java.util.Set;

import java.util.HashSet;

public class ClientBancaireDto {
    private Long id;
    private Set<PersonneDto> personnesDtos = new HashSet<>();

    public ClientBancaireDto() {}

    public ClientBancaireDto(Long id, Set<PersonneDto> personnesDtos) {
        this.id = id;
        this.personnesDtos = personnesDtos;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Set<PersonneDto> getPersonnesDtos() {
        return personnesDtos;
    }

    public void addPersonne(PersonneDto personne) {
        this.personnesDtos.add(personne);
    }

    public void removePersonne(PersonneDto personne) {
        this.personnesDtos.remove(personne);
    }
}
