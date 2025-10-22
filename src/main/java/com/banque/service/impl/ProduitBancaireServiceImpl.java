package com.banque.service.impl;
import com.banque.model.ProduitBancaire;
import com.banque.repository.ProduitBancaireRepository;
import com.banque.service.ProduitBancaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProduitBancaireServiceImpl implements ProduitBancaireService {

    private ProduitBancaireRepository produitBancaireRepository;

    @Autowired
    public ProduitBancaireServiceImpl(ProduitBancaireRepository ProduitBancaireRepository) {
        this.produitBancaireRepository = ProduitBancaireRepository;
    }

    @Override
    public List<ProduitBancaire> getAllProduitBancaire()
    {
        return produitBancaireRepository.findAll();
    }

    @Override
    public ProduitBancaire createProduitBancaire(ProduitBancaire produitBancaire)
    {
        return produitBancaireRepository.save(produitBancaire);
    }

    @Override
    public ProduitBancaire getProduitBancaireById(Long id)
    {
        return produitBancaireRepository.findById(id).orElseThrow();
    }

    @Override
    public ProduitBancaire updateProduitBancaire(ProduitBancaire produitBancaire)
    {
        return produitBancaireRepository.save(produitBancaire);
    }

    @Override
    public void deleteProduitBancaireById(Long id)
    {
        produitBancaireRepository.findById(id).orElseThrow();
        produitBancaireRepository.deleteById(id);
    }

    @Override
    public float getSoldeByProduit(Long produitId) {
        ProduitBancaire produit = produitBancaireRepository.findById(produitId)
                .orElseThrow(() -> new RuntimeException("Compte introuvable"));
        return produit.getSolde_courant();
    }
}
