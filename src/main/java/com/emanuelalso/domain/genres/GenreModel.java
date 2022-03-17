package com.emanuelalso.domain.genres;

import com.emanuelalso.domain.people.PersonModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GenreModel {
    private Long id;
    private String genreName;
    private List<PersonModel> peopleList;
}
