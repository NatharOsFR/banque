package com.banque.service;
import com.banque.model.PersonneMorale;
import java.util.List;

public interface PersonneMoraleService {
    public List<PersonneMorale> getAllPersonneMorale();
    public PersonneMorale createPersonneMorale(PersonneMorale personneMorale);
    public PersonneMorale getPersonneMoraleById(Long id);
    public PersonneMorale updatePersonneMorale(PersonneMorale personneMorale);
    void deletePersonneMoraleById(Long id);
}