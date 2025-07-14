package com.codewithudo.movielibraryapi.controller;

import com.codewithudo.movielibraryapi.model.Movie;
import com.codewithudo.movielibraryapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // Get all movies
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    // Get movie by ID
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id) {
        Movie movie = movieService.getMovieById(id);
        if (movie != null) {
            return new ResponseEntity<>(movie, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Add a new movie
    @PostMapping
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        boolean added = movieService.addMovie(movie);
        if (added) {
            return new ResponseEntity<>("Movie added successfully!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Failed to add movie.", HttpStatus.BAD_REQUEST);
    }

    // Update movie by ID
    @PutMapping("/{id}")
    public ResponseEntity<String> updateMovie(@PathVariable int id, @RequestBody Movie movie) {
        boolean updated = movieService.updateMovie(id, movie);
        if (updated) {
            return new ResponseEntity<>("Movie updated successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Movie not found.", HttpStatus.NOT_FOUND);
    }

    // Delete movie by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable int id) {
        boolean deleted = movieService.deleteMovie(id);
        if (deleted) {
            return new ResponseEntity<>("Movie deleted successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Movie not found.", HttpStatus.NOT_FOUND);
    }
}
