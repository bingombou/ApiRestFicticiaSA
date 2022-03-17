package com.emanuelalso.domain.people;

import java.util.List;

public interface PersonService {

    PersonModel save(PersonModel personModel);

    PersonModel update(PersonModel personModel);

    void deleteById(Long personId);

    List<PersonModel> findAll();
}
