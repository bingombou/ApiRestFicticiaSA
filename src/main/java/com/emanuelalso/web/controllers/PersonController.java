package com.emanuelalso.web.controllers;

import com.emanuelalso.domain.people.PersonModel;
import com.emanuelalso.domain.people.PersonService;
import com.emanuelalso.web.dto.PersonDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService){this.personService = personService;}

    @PostMapping
    public ResponseEntity<PersonDto> create(@RequestBody PersonModel personModel){
        return ResponseEntity.ok(toPersonDto(personService.save(personModel)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDto> update(@PathVariable Long id, @RequestBody PersonModel personModel){
        return ResponseEntity.ok(toPersonDto(personService.update(personModel)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        personService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> findAll(){
        return ResponseEntity.ok(personService.findAll()
                .stream()
                .map(this::toPersonDto)
                .collect(Collectors.toList()));
    }

    private PersonDto toPersonDto(PersonModel personModel){
        return new PersonDto(personModel.getId(), personModel.getName(), personModel.getSurname(),
                personModel.getDni(), personModel.getAge(), personModel.getGenreId(), personModel.getStatus());
    }

}

