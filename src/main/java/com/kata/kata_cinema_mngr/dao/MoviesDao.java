package com.kata.kata_cinema_mngr.dao;

import com.kata.kata_cinema_mngr.model.MovieModel;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.sql.SQLException;
import java.util.List;

public interface MoviesDao {

    @SqlQuery("SELECT * FROM movies;")
    @RegisterBeanMapper(MovieModel.class)
    List<MovieModel> getMovies() throws SQLException;

    @SqlUpdate("INSERT INTO movies (title, genre, running_time, qualification) VALUES (:title, :genre, :running_time, :qualification);")
    @GetGeneratedKeys
    Integer addMovie(@Bind("title") String title, @Bind("genre") String genre, @Bind("running_time") int running_time, @Bind("qualification") String qualification) throws SQLException;

}
