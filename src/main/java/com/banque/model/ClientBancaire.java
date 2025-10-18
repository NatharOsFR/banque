package com.banque.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static jakarta.persistence.GenerationType.SEQUENCE;


@Entity
public class ClientBancaire {
    @Id
    @SequenceGenerator( name = "client_bancaire_sequence", sequenceName = "client_bancaire_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE,generator = "client_bancaire_sequence")
    @Column(name = "id")
    protected Long id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(
            name = "client_personne",
            joinColumns = { @JoinColumn(name = "client_bancaire_id") },
            inverseJoinColumns = { @JoinColumn(name = "personne_id") })
    private List<Personne> personnes = new ArrayList<>();


    public ClientBancaire() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public List<Personne> getPersonnes() {
        return personnes;
    }
    public void setPersonnes(List<Personne> personnes) {
        this.personnes = personnes;
    }
    public void addPersonne(Personne personne)
    {
        personnes.add(personne);
        personne.addClientBancaire(this);
    }
    public void removePersonne(Personne personne)
    {
        personnes.remove(personne);
        personne.getClientsBancaires().remove(this);
    }

    @OneToMany(mappedBy = "clientBancaire", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProduitBancaire> produitsBancaires = new ArrayList<>();

    public List<ProduitBancaire> getProduitsBancaires() {
        return produitsBancaires;
    }

    public void addProduitBancaire(ProduitBancaire produit) {
        produitsBancaires.add(produit);
        produit.setClientBancaire(this);
    }

    public void removeProduitBancaire(ProduitBancaire produit) {
        produitsBancaires.remove(produit);
        produit.setClientBancaire(null);
    }

    @Override
    public String toString() {
        return "\nClientBancaire{" +
                "\n\tid=" + id +
                '}';
    }

    @PreRemove
    private void gererLiens()
    {
        for (Personne personne : this.personnes) {
            personne.getClientsBancaires().remove(this);
        }
        this.personnes.clear();

        for (ProduitBancaire produit : this.produitsBancaires) {
            produit.setClientBancaire(null);
        }
        this.produitsBancaires.clear();
    }

}
