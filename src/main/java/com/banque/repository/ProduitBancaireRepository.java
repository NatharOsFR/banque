package com.banque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.banque.model.ProduitBancaire;

public interface ProduitBancaireRepository extends JpaRepository<ProduitBancaire, Long> {
}