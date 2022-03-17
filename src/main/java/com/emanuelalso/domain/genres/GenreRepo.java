package com.emanuelalso.domain.genres;

import java.util.List;
import java.util.Optional;

public interface GenreRepo {

    GenreModel create(GenreModel genreModel);

    GenreModel updatePerson(GenreModel genreModel);

    void deleteByPersonId(Long genreId);

    List<GenreModel> findAll();

    Optional<GenreModel> findById(Long id);
}
