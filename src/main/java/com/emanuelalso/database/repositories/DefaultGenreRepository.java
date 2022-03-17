package com.emanuelalso.database.repositories;

import com.emanuelalso.database.entities.GenreEntity;
import com.emanuelalso.database.entities.PersonEntity;
import com.emanuelalso.database.jparepositories.GenreJpaRepository;
import com.emanuelalso.domain.genres.GenreModel;
import com.emanuelalso.domain.genres.GenreRepo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DefaultGenreRepository implements GenreRepo {

    private GenreJpaRepository genreJpaRepository;

    public DefaultGenreRepository(GenreJpaRepository genreJpaRepository){this.genreJpaRepository = genreJpaRepository;}

    @Override
    public GenreModel create(GenreModel genreModel) {
        genreJpaRepository.save(toEntity(genreModel));
        return genreModel;
    }

    @Override
    public GenreModel updatePerson(GenreModel genreModel) {
        genreJpaRepository.save(toEntity(genreModel));
        return genreModel;
    }

    @Override
    public void deleteByPersonId(Long genreId) {
        genreJpaRepository.deleteById(genreId);
    }

    @Override
    public List<GenreModel> findAll() {
        return genreJpaRepository.findAll()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<GenreModel> findById(Long id) {
        Optional<GenreEntity> genreOptional = genreJpaRepository.findById(id);
        return (genreOptional.isPresent()) ? Optional.of(toModel(genreOptional.get())) : Optional.empty();
    }

    public GenreEntity toEntity(GenreModel genreModel){
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setId(genreModel.getId());
        genreEntity.setGenreName(genreModel.getGenreName());
        return genreEntity;
    }

    public GenreModel toModel(GenreEntity genreEntity){
        GenreModel genreModel = new GenreModel();
        genreModel.setId(genreEntity.getId());
        genreModel.setGenreName(genreEntity.getGenreName());
        return genreModel;
    }
}
