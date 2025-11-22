package com.banque.service.impl;

import com.banque.dataTransferObjects.OperationDto;
import com.banque.dataTransferObjects.ProduitBancaireDto;
import com.banque.dataTransferObjects.VirementDto;
import com.banque.mappers.OperationMapper;
import com.banque.mappers.ProduitBancaireMapper;
import com.banque.model.Operation;
import com.banque.model.ProduitBancaire;
import com.banque.service.MobileBanqueService;
import com.banque.service.OperationService;
import com.banque.service.ProduitBancaireService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MobileBanqueServiceImpl implements MobileBanqueService {

    @Autowired
    private ProduitBancaireService produitService;

    @Autowired
    private OperationService operationService;

    @Override
    public List<OperationDto> getLastFiveOperations(Long produitId) {

        ProduitBancaire produit =
                produitService.getProduitBancaireById(produitId);

        return operationService.getLast5OperationsByProduit(produit)
                .stream()
                .map(OperationMapper::toDto)
                .toList();
    }

    @Override
    public ProduitBancaireDto getProduitDetails(Long produitId) {
        ProduitBancaire pb = produitService.getProduitBancaireById(produitId);
        return ProduitBancaireMapper.toDto(pb);
    }

    @Override
    public void faireVirement(VirementDto request) {

        Long sourceId = request.getSourceId();
        Long destId = request.getDestId();
        float montant = request.getMontant();

        ProduitBancaire source = produitService.getProduitBancaireById(sourceId);
        ProduitBancaire dest = produitService.getProduitBancaireById(destId);

        if (source == null || dest == null) {
            throw new RuntimeException("Un des comptes bancaires est introuvable");
        }

        if (montant <= 0) {
            throw new IllegalArgumentException("Le montant doit être positif");
        }

        if (source.getSolde_courant() < montant) {
            throw new RuntimeException("Solde insuffisant");
        }

        source.setSolde_courant(source.getSolde_courant() - montant);
        dest.setSolde_courant(dest.getSolde_courant() + montant);

        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());

        Operation debit = new Operation(
                date,
                -montant,
                "VIREMENT_SORTANT",
                "Virement vers " + dest.getNumeroCompte(),
                source
        );

        Operation credit = new Operation(
                date,
                montant,
                "VIREMENT_ENTRANT",
                "Virement depuis " + source.getNumeroCompte(),
                dest
        );

        operationService.createOperation(debit);
        operationService.createOperation(credit);

        produitService.updateProduitBancaire(source);
        produitService.updateProduitBancaire(dest);
    }
}