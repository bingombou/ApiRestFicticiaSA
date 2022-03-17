package com.emanuelalso.domain.people;

import com.emanuelalso.database.entities.GenreEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PersonModel {

    private Long id;
    private String name;
    private String surname;
    private int dni;
    private int age;
    private GenreEntity genreId;
    private Boolean status;
    private Boolean drives;
    private Boolean glasses;
    private Boolean diabetic;
    private Boolean otherDisease;
    private String disease;
}
