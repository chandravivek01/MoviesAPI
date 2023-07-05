package com.vcs.movies.controller;

import com.vcs.movies.model.Movie;
import com.vcs.movies.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getSingleMovie(@PathVariable ObjectId id) {
        return new ResponseEntity<Movie>(movieService.singleMovie(id), HttpStatus.OK);
    }

    @GetMapping("/imdb/{imdbId}")
    public ResponseEntity<Movie> getSingleMovieByImdbId(@PathVariable String imdbId) {
        return new ResponseEntity<Movie>(movieService.singleMovieByImdbId(imdbId), HttpStatus.OK);
    }

}
