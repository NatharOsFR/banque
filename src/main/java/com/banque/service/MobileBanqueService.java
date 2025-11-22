package com.banque.service;

import com.banque.dataTransferObjects.OperationDto;
import com.banque.dataTransferObjects.ProduitBancaireDto;
import com.banque.dataTransferObjects.VirementDto;

import java.util.List;

public interface MobileBanqueService {
    List<OperationDto> getLastFiveOperations(Long produitId);
    ProduitBancaireDto getProduitDetails(Long produitId);
    void faireVirement(VirementDto request);
}