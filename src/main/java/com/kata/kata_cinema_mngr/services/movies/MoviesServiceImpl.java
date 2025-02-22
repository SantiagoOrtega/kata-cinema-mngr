package com.kata.kata_cinema_mngr.services.movies;

import com.kata.kata_cinema_mngr.dao.MoviesDao;
import com.kata.kata_cinema_mngr.model.MovieModel;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MoviesServiceImpl implements MoviesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MoviesServiceImpl.class);
    private Jdbi jdbi;

    public MoviesServiceImpl(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    @Override
    public MovieModel getMovieById(Long movieId) {
        try(Handle handle = jdbi.open()) {
            MoviesDao moviesDao = handle.attach(MoviesDao.class);
            LOGGER.info("COMPLETO TRY DE GET MOVIE CON ID: {}", movieId);
            return moviesDao.getMovieById(movieId);
        } catch (Exception e) {
            LOGGER.error("ENTRO AL CATCH DE GET TASK CON ID: {}", movieId, e);
            return new MovieModel();
        }
    }

    @Override
    public Integer addMovie(MovieModel movieModel) {
        try(Handle handle = jdbi.open()) {
            MoviesDao moviesDao = handle.attach(MoviesDao.class);
            Integer addMovieId = moviesDao.addMovie(movieModel.getTitle(), movieModel.getGenre(), movieModel.getRunning_Time(),
                    movieModel.getQualification());
            LOGGER.info("Movie add successfully, id: {}", addMovieId);
            return addMovieId;
        } catch (Exception e) {
            LOGGER.error("Error to add Movie", e);
            return 0;
        }
    }

}
