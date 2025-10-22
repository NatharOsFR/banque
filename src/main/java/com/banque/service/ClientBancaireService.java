package com.banque.service;
import com.banque.model.ClientBancaire;
import java.util.List;

public interface ClientBancaireService {
    public List<ClientBancaire> getAllClientBancaire();
    public ClientBancaire createClientBancaire(ClientBancaire clientBancaire);
    public ClientBancaire getClientBancaireById(Long id);
    public ClientBancaire updateClientBancaire(ClientBancaire clientBancaire);
    void deleteClientBancaireById(Long id);
}