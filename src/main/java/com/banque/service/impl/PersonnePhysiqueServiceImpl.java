package com.banque.service.impl;

import com.banque.model.PersonnePhysique;
import com.banque.repository.PersonnePhysiqueRepository;
import com.banque.service.PersonnePhysiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonnePhysiqueServiceImpl implements PersonnePhysiqueService {

    private PersonnePhysiqueRepository PersonnePhysiqueRepository;

    @Autowired
    public PersonnePhysiqueServiceImpl(PersonnePhysiqueRepository PersonnePhysiqueRepository) {
        this.PersonnePhysiqueRepository = PersonnePhysiqueRepository;
    }

    @Override
    public List<PersonnePhysique> getAllPersonnePhysique()
    {
        return PersonnePhysiqueRepository.findAll();
    }

    @Override
    public PersonnePhysique createPersonnePhysique(PersonnePhysique PersonnePhysique)
    {
        return PersonnePhysiqueRepository.save(PersonnePhysique);
    }

    @Override
    public PersonnePhysique getPersonnePhysiqueById(Long id)
    {
        return PersonnePhysiqueRepository.findById(id).orElseThrow();
    }

    @Override
    public PersonnePhysique updatePersonnePhysique(PersonnePhysique PersonnePhysique)
    {
        return PersonnePhysiqueRepository.save(PersonnePhysique);
    }

    @Override
    public void deletePersonnePhysiqueById(Long id)
    {
        PersonnePhysiqueRepository.findById(id).orElseThrow();
        PersonnePhysiqueRepository.deleteById(id);
    }
}
