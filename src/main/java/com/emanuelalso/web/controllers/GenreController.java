package com.emanuelalso.web.controllers;

import com.emanuelalso.domain.genres.GenreModel;
import com.emanuelalso.domain.genres.GenreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genre")
public class GenreController {

    private GenreService genreService;

    public GenreController(GenreService genreService){this.genreService = genreService;}

    @PostMapping
    public ResponseEntity<GenreModel> create(@RequestBody GenreModel genreModel){
        return ResponseEntity.ok(genreService.save(genreModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenreModel> update(@PathVariable Long id, @RequestBody GenreModel genreModel){
        return ResponseEntity.ok(genreService.update(genreModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        genreService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<GenreModel>> findAll(){
        return ResponseEntity.ok(genreService.findAll());
    }
}
