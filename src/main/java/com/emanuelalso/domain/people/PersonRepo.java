package com.emanuelalso.domain.people;

import java.util.List;
import java.util.Optional;

public interface PersonRepo {

    PersonModel create(PersonModel personModel);

    PersonModel updatePerson(PersonModel personModel);

    void deleteByPersonId(Long personId);

    List<PersonModel> findAll();

    Optional<PersonModel> findById(Long id);
}
