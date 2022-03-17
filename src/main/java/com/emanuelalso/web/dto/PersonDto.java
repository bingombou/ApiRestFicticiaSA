package com.emanuelalso.web.dto;

import com.emanuelalso.database.entities.GenreEntity;
import lombok.*;

@AllArgsConstructor
@Setter
@Getter
public class PersonDto{
    private Long id;
    private String name;
    private String surname;
    private int dni;
    private int age;
    private GenreEntity genreId;
    private Boolean status;
}
