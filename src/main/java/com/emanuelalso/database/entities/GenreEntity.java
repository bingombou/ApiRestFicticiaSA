package com.emanuelalso.database.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "genre")
public class GenreEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genre", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", length = 50)
    private String genreName;

    @JsonManagedReference
    @OneToMany(mappedBy = "genreId", fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.REFRESH,
            CascadeType.REMOVE })
    private List<PersonEntity> peopleList = new ArrayList<>();
}
