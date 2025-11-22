package com.banque.dataTransferObjects;

import java.util.Set;
import java.util.HashSet;

public class ProduitBancaireDto {

    private Long id;
    private float soldeCourant;
    private String numeroCompte;
    private TypeProduitDto typeProduitDto;
    private ClientBancaireDto clientBancaireDto;
    private Set<OperationDto> operationDtos = new HashSet<>();

    public ProduitBancaireDto() {}

    public ProduitBancaireDto(Long id, float soldeCourant, String numeroCompte, TypeProduitDto typeProduitDto, ClientBancaireDto clientBancaireDto, Set<OperationDto> operationDtos) {
        this.id = id;
        this.soldeCourant = soldeCourant;
        this.numeroCompte = numeroCompte;
        this.typeProduitDto = typeProduitDto;
        this.clientBancaireDto = clientBancaireDto;
        this.operationDtos = operationDtos;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public float getSoldeCourant() {
        return soldeCourant;
    }
    public void setSoldeCourant(float soldeCourant) {
        this.soldeCourant = soldeCourant;
    }
    public String getNumeroCompte() {
        return numeroCompte;
    }
    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }
    public TypeProduitDto getTypeProduitDto() {
        return typeProduitDto;
    }
    public void setTypeProduitDto(TypeProduitDto typeProduitDto) {
        this.typeProduitDto = typeProduitDto;
    }
    public ClientBancaireDto getClientBancaireDto() {
        return clientBancaireDto;
    }
    public void setClientBancaireDto(ClientBancaireDto clientBancaireDto) {
        this.clientBancaireDto = clientBancaireDto;
    }
    public Set<OperationDto> getOperationDtos() {
        return operationDtos;
    }
    public void setOperationDtos(Set<OperationDto> operationDtos) {
        this.operationDtos = operationDtos;
    }

}
