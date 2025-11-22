package com.banque.dataTransferObjects;

import java.sql.Date;

public class OperationDto {
    private Long id;
    private String intituleOperation;
    private String typeOperation;
    private Date dateOperation;
    private float montant;

    public OperationDto() {}

    public OperationDto(Long id, String intituleOperation, String typeOperation, Date dateOperation, float montant) {
        this.id = id;
        this.intituleOperation = intituleOperation;
        this.typeOperation = typeOperation;
        this.dateOperation = dateOperation;
        this.montant = montant;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getIntituleOperation() {
        return intituleOperation;
    }
    public void setIntituleOperation(String intituleOperation) {
        this.intituleOperation = intituleOperation;
    }
    public String getTypeOperation() {
        return typeOperation;
    }
    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
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
}

