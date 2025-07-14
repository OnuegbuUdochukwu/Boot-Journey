package com.codewithudo.movielibraryapi.service;

import com.codewithudo.movielibraryapi.model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private final List<Movie> movies = new ArrayList<>();
    private int nextId = 1;

    // Add a new movie
    public boolean addMovie(Movie movie) {
        movie.setId(nextId++);
        movies.add(movie);
        return true;
    }

    // Get all movies
    public List<Movie> getAllMovies() {
        return movies;
    }

    // Get movie by ID
    public Movie getMovieById(int id) {
        for (Movie movie : movies) {
            if (movie.getId().equals(id)) {
                return movie;
            }
        }
        return null;
    }

    // Update movie details
    public boolean updateMovie(int id, Movie updatedMovie) {
        for (Movie movie : movies) {
            if (movie.getId().equals(id)) {
                movie.setTitle(updatedMovie.getTitle());
                movie.setGenre(updatedMovie.getGenre());
                movie.setDirector(updatedMovie.getDirector());
                movie.setReleaseYear(updatedMovie.getReleaseYear());
                movie.setRating(updatedMovie.getRating());
                return true;
            }
        }
        return false;
    }

    // Delete movie by ID
    public boolean deleteMovie(int id) {
        for (Movie movie : movies) {
            if (movie.getId().equals(id)) {
                movies.remove(movie);
                return true;
            }
        }
        return false;
    }
}
