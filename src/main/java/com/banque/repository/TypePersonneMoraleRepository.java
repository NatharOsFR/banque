package com.banque.repository;

import com.banque.model.TypePersonneMorale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TypePersonneMoraleRepository extends JpaRepository<TypePersonneMorale, Long> {
    @Query("SELECT c FROM TypePersonneMorale c where c.intitule= :intitule")
    ArrayList<TypePersonneMorale> findByTypePersonneMorale(@Param("intitule")String intitule);
    ArrayList<TypePersonneMorale> findByIntitule(String intitule);
}