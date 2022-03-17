package com.emanuelalso.database.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "person")
public class PersonEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id_person" ,unique = true, nullable = false)
    private Long id;

    @Column(name = "first_name", length = 30, nullable = false)
    private String name;

    @Column(name = "last_name", length = 30, nullable = false)
    private String surname;

    @Column(name = "DNI", length = 8, nullable = false)
    private int dni;

    @Column(length = 2)
    private int age;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER, cascade ={ CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.REFRESH,
            CascadeType.REMOVE})
    @JoinColumn(name = "id_genre")
    private GenreEntity genreId;

    @Column(nullable = false)
    private Boolean status = Boolean.FALSE;

    @Column(nullable = false)
    private Boolean drives = Boolean.FALSE;

    @Column(nullable = false)
    private Boolean glasses = Boolean.FALSE;

    @Column(nullable = false)
    private Boolean diabetic = Boolean.FALSE;

    @Column(name = "other_disease",nullable = false)
    private Boolean otherDisease = Boolean.FALSE;

    @Column(length = 100)
    private String disease;

}
