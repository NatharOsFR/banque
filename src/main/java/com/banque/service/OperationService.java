package com.banque.service;
import com.banque.model.Operation;
import com.banque.model.ProduitBancaire;

import java.util.List;

public interface OperationService {
    public List<Operation> getAllOperation();
    public Operation createOperation(Operation operation);
    public Operation getOperationById(Long id);
    public Operation updateOperation(Operation operation);
    void deleteOperationById(Long id);
    List<Operation> getLast5OperationsByProduit(ProduitBancaire produit);

}