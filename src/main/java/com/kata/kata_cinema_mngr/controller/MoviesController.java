package com.kata.kata_cinema_mngr.controller;

import com.kata.kata_cinema_mngr.model.MovieModel;
import com.kata.kata_cinema_mngr.services.movies.MoviesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoviesController {

    private MoviesService moviesService;

    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @GetMapping("/getMovie/{id}")
    public MovieModel getMovie(@PathVariable Long id) {
        return moviesService.getMovieById(id);
    }

}
