package com.kata.kata_cinema_mngr.services.movies;

import com.kata.kata_cinema_mngr.model.MovieModel;

import java.util.List;

public interface MoviesService {

    List<MovieModel> getMovies();

    Integer addMovie(MovieModel movieModel);

}
