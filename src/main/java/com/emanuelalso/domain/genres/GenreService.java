package com.emanuelalso.domain.genres;

import java.util.List;

public interface GenreService {

    GenreModel save(GenreModel genreModel);

    GenreModel update(GenreModel genreModel);

    void deleteById(Long genreId);

    List<GenreModel> findAll();
}
