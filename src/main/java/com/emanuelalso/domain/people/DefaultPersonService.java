package com.emanuelalso.domain.people;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultPersonService implements PersonService{

    private PersonRepo personRepo;

    public DefaultPersonService(PersonRepo personRepo){ this.personRepo = personRepo; }

    @Override
    public PersonModel save(PersonModel personModel) { return personRepo.create(personModel); }

    @Override
    public PersonModel update(PersonModel personModel) {
        personRepo.findById(personModel.getId()).orElseThrow(RuntimeException::new);
        return personRepo.updatePerson(personModel);
    }

    @Override
    public void deleteById(Long personId) {
        personRepo.findById(personId).orElseThrow(RuntimeException::new);
        personRepo.deleteByPersonId(personId);
    }

    @Override
    public List<PersonModel> findAll() {
        return personRepo.findAll();
    }
}
