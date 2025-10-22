package com.banque.repository;

import com.banque.model.Operation;
import com.banque.model.ProduitBancaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation, Long> {

    @Query("SELECT o FROM Operation o WHERE o.produitBancaire = :produit ORDER BY o.dateOperation DESC")
    List<Operation> findTop5ByProduitBancaireOrderByDateOperationDesc(ProduitBancaire produit);
}
