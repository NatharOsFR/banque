package com.banque.dataTransferObjects;

public class VirementDto {

    private Long sourceId;
    private Long destId;
    private float montant;

    public VirementDto() {}

    public VirementDto(Long sourceId, Long destId, float montant) {
        this.sourceId = sourceId;
        this.destId = destId;
        this.montant = montant;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Long getDestId() {
        return destId;
    }

    public void setDestId(Long destId) {
        this.destId = destId;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }
}