package com.banque.service.impl;

import com.banque.model.PersonneMorale;
import com.banque.repository.PersonneMoraleRepository;
import com.banque.service.PersonneMoraleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonneMoraleServiceImpl implements PersonneMoraleService {

    private PersonneMoraleRepository PersonneMoraleRepository;

    @Autowired
    public PersonneMoraleServiceImpl(PersonneMoraleRepository PersonneMoraleRepository) {
        this.PersonneMoraleRepository = PersonneMoraleRepository;
    }

    @Override
    public List<PersonneMorale> getAllPersonneMorale()
    {
        return PersonneMoraleRepository.findAll();
    }

    @Override
    public PersonneMorale createPersonneMorale(PersonneMorale PersonneMorale)
    {
        return PersonneMoraleRepository.save(PersonneMorale);
    }

    @Override
    public PersonneMorale getPersonneMoraleById(Long id)
    {
        return PersonneMoraleRepository.findById(id).orElseThrow();
    }

    @Override
    public PersonneMorale updatePersonneMorale(PersonneMorale PersonneMorale)
    {
        return PersonneMoraleRepository.save(PersonneMorale);
    }

    @Override
    public void deletePersonneMoraleById(Long id)
    {
        PersonneMoraleRepository.findById(id).orElseThrow();
        PersonneMoraleRepository.deleteById(id);
    }
}
