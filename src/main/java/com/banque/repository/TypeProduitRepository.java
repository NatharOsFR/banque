package com.banque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.banque.model.TypeProduit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface TypeProduitRepository extends JpaRepository<TypeProduit, Long> {

    @Query("SELECT c FROM TypeProduit c where c.intitule= :intitule")
    ArrayList<TypeProduit> findByTypeProduit(@Param("intitule")String intitule);
    ArrayList<TypeProduit> findByIntitule(String intitule);
    ArrayList<TypeProduit> findByIntituleLike(String typeProduit);
    ArrayList<TypeProduit> findByIntituleContains(String typeProduit);
    ArrayList<TypeProduit> findFirst3ByOrderByIdDesc();
    ArrayList<TypeProduit> findByTauxInteretAgiosGreaterThanEqualOrderByTauxInteretAgiosAsc(float taux);
}