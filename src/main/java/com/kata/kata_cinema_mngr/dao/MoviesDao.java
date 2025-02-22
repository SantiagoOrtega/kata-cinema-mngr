package com.kata.kata_cinema_mngr.dao;

import com.kata.kata_cinema_mngr.model.MovieModel;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.sql.SQLException;

public interface MoviesDao {

    @SqlQuery("SELECT * FROM movies WHERE id= :movieId;")
    @RegisterBeanMapper(MovieModel.class)
    MovieModel getMovieById(@Bind("movieId") Long movieId) throws SQLException;

}
