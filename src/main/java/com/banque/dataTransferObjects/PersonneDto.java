package com.banque.dataTransferObjects;

public class PersonneDto {
    private Long id;
    private String nom;
    private String adresse;
    private String typePersonne;

    public PersonneDto() {}

    public PersonneDto(Long id, String nom, String adresse, String typePersonne) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.typePersonne = typePersonne;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public PersonneDto(Long id) {
        this.id = id;
    }

    public void init(Long id){
        this.id = id;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getTypePersonne() {
        return typePersonne;
    }

    public void setTypePersonne(String typePersonne) {
        this.typePersonne = typePersonne;
    }

    public String nomComplet() {
        return nom;
    }

    @Override
    public String toString() {
        return "PersonneDto{" +
                "id='" + id + '\'' +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", typePersonne='" + typePersonne + '\'' +
                '}';
    }
}
