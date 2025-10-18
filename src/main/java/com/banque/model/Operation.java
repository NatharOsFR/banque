package com.banque.model;

import jakarta.persistence.*;
import java.sql.Date; // ✅ utilisation de java.sql.Date

@Entity
@Table(name = "operation")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "operation_seq")
    @SequenceGenerator(name = "operation_seq", sequenceName = "operation_seq", allocationSize = 1)
    private Long id;

    @Column(name = "date_operation", nullable = false, columnDefinition = "DATE")
    private Date dateOperation;

    @Column(name = "montant", nullable = false)
    private float montant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produit_bancaire_id")
    private ProduitBancaire produitBancaire;

    public Operation() {}

    public Operation(Date dateOperation, float montant, ProduitBancaire produitBancaire) {
        this.dateOperation = dateOperation;
        this.montant = montant;
        this.produitBancaire = produitBancaire;
    }

    public Long getId() {
        return id;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public ProduitBancaire getProduitBancaire() {
        return produitBancaire;
    }

    public void setProduitBancaire(ProduitBancaire produitBancaire) {
        this.produitBancaire = produitBancaire;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", dateOperation=" + dateOperation +
                ", montant=" + montant +
                '}';
    }
}