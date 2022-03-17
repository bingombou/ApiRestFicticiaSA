package com.emanuelalso.database.repositories;

import com.emanuelalso.database.entities.PersonEntity;
import com.emanuelalso.database.jparepositories.PersonJpaRepository;
import com.emanuelalso.domain.people.PersonModel;
import com.emanuelalso.domain.people.PersonRepo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DefaultPersonRepository implements PersonRepo {

    private PersonJpaRepository personJpaRepository;

    public DefaultPersonRepository(PersonJpaRepository personJpaRepository){this.personJpaRepository = personJpaRepository;}

    @Override
    public PersonModel create(PersonModel personModel) {
        personJpaRepository.save(toEntity(personModel));
        return personModel;
    }

    @Override
    public PersonModel updatePerson(PersonModel personModel) {
        personJpaRepository.save(toEntity(personModel));
        return personModel;
    }

    @Override
    public void deleteByPersonId(Long personId) {
        personJpaRepository.deleteById(personId);
    }

    @Override
    public List<PersonModel> findAll() {
        return personJpaRepository.findAll()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PersonModel> findById(Long id) {
        Optional<PersonEntity> personOptional = personJpaRepository.findById(id);
        return (personOptional.isPresent()) ? Optional.of(toModel(personOptional.get())) : Optional.empty();
    }

    public PersonEntity toEntity(PersonModel personModel){
        return new PersonEntity(personModel.getId(), personModel.getName(), personModel.getSurname(), personModel.getDni(),
                personModel.getAge(), personModel.getGenreId(), personModel.getStatus(), personModel.getDrives(),
                personModel.getGlasses(), personModel.getDiabetic(), personModel.getOtherDisease(), personModel.getDisease());
    }

    public PersonModel toModel(PersonEntity personEntity){
        return new PersonModel(personEntity.getId(), personEntity.getName(), personEntity.getSurname(), personEntity.getDni(),
                personEntity.getAge(), personEntity.getGenreId(), personEntity.getStatus(), personEntity.getDrives(),
                personEntity.getGlasses(), personEntity.getDiabetic(), personEntity.getOtherDisease(), personEntity.getDisease());
    }
}
