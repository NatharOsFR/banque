package com.banque.service.impl;

import com.banque.model.Operation;
import com.banque.model.ProduitBancaire;
import com.banque.repository.OperationRepository;
import com.banque.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OperationServiceImpl implements OperationService {

    private OperationRepository operationRepository;

    @Autowired
    public OperationServiceImpl(OperationRepository OperationRepository) {
        this.operationRepository = OperationRepository;
    }

    @Override
    public List<Operation> getAllOperation()
    {
        return operationRepository.findAll();
    }

    @Override
    public Operation createOperation(Operation operation)
    {
        return operationRepository.save(operation);
    }

    @Override
    public Operation getOperationById(Long id)
    {
        return operationRepository.findById(id).orElseThrow();
    }

    @Override
    public Operation updateOperation(Operation operation)
    {
        return operationRepository.save(operation);
    }

    @Override
    public void deleteOperationById(Long id)
    {
        operationRepository.findById(id).orElseThrow();
        operationRepository.deleteById(id);
    }

    @Override
    public List<Operation> getLast5OperationsByProduit(ProduitBancaire produit) {
        if (produit == null) throw new IllegalArgumentException("ProduitBancaire ne peut pas être null");
        return operationRepository.findTop5ByProduitBancaireOrderByDateOperationDesc(produit);
    }
}
