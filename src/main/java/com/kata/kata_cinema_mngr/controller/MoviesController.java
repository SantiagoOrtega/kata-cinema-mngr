package com.kata.kata_cinema_mngr.controller;

import com.kata.kata_cinema_mngr.model.MovieModel;
import com.kata.kata_cinema_mngr.services.movies.MoviesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MoviesController {

    private MoviesService moviesService;

    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @GetMapping("/getMovie/{id}")
    public MovieModel getMovie(@PathVariable Long id) {
        return moviesService.getMovieById(id);
    }

    @PostMapping("/addMovie")
    public ResponseEntity<Integer> addMovie(@RequestBody MovieModel movieModel) {
        Integer addMovieId = moviesService.addMovie(movieModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(addMovieId);
    }

}
