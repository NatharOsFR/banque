package com.banque.service;
import com.banque.model.ProduitBancaire;

import java.util.List;

public interface ProduitBancaireService {
    public List<ProduitBancaire> getAllProduitBancaire();
    public ProduitBancaire createProduitBancaire(ProduitBancaire produitBancaire);
    public ProduitBancaire getProduitBancaireById(Long id);
    public ProduitBancaire updateProduitBancaire(ProduitBancaire produitBancaire);
    void deleteProduitBancaireById(Long id);
    float getSoldeByProduit(Long produitId);
}