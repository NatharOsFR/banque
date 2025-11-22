package com.banque.dataTransferObjects;

import java.util.Objects;

public class TypeProduitDto {
    private Long id;
    private String intitule;
    private float cotisationCarte;

    private float tauxInteretAgios;

    public TypeProduitDto() {}

    public TypeProduitDto(Long id, String intitule, float cotisationCarte, float tauxInteretAgios) {
        this.id = id;
        this.intitule = intitule;
        this.cotisationCarte = cotisationCarte;
        this.tauxInteretAgios = tauxInteretAgios;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
    public String getIntitule() {
        return intitule;
    }
    public float getCotisationCarte() {
        return cotisationCarte;
    }
    public void setCotisationCarte(float cotisationCarte) {
        this.cotisationCarte = cotisationCarte;
    }
    public float getTauxInteretAgios() {
        return tauxInteretAgios;
    }
    public void setTauxInteretAgios(float tauxInteretAgios) {
        this.tauxInteretAgios = tauxInteretAgios;
    }

    @Override
    public String toString() {
        return "TypeProduitDto{" +
                "id='" + id + '\'' +
                ", intitule='" + intitule + '\'' +
                ", cotisationCarte=" + cotisationCarte +
                ", tauxInteretAgios=" + tauxInteretAgios +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeProduitDto that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
