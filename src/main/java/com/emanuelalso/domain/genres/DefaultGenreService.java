package com.emanuelalso.domain.genres;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultGenreService implements GenreService{

    private GenreRepo genreRepo;

    public DefaultGenreService(GenreRepo genreRepo){this.genreRepo = genreRepo;}

    @Override
    public GenreModel save(GenreModel genreModel) {
        return genreRepo.create(genreModel);
    }

    @Override
    public GenreModel update(GenreModel genreModel) {
        genreRepo.findById(genreModel.getId()).orElseThrow(RuntimeException::new);
        return genreRepo.updatePerson(genreModel);
    }

    @Override
    public void deleteById(Long genreId) {
        genreRepo.findById(genreId).orElseThrow(RuntimeException::new);
        genreRepo.deleteByPersonId(genreId);
    }

    @Override
    public List<GenreModel> findAll() {
        return genreRepo.findAll();
    }
}
