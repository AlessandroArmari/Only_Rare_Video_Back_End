package com.digitazon.onlyrarevideobe.controller.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitazon.onlyrarevideobe.model.Movie;
import com.digitazon.onlyrarevideobe.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/movie")
@CrossOrigin
public class MovieController {

    @Autowired
    MovieService movieService;

    // GET ALL
    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    // GET BY ID
    @GetMapping("/id")
    public ResponseEntity<Movie> getMovieById(@RequestParam Long id) {
        return new ResponseEntity<>(movieService.getMovieById(id), HttpStatus.OK);
    }

    // POST A MOVIE
    @PostMapping("/create")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie newMovie) {
        return new ResponseEntity<>(movieService.createMovie(newMovie), HttpStatus.CREATED);
    }

    // DELETE BY ID
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteMovieById(@RequestParam Long id) {
        movieService.deleteMovieById(id);
        return new ResponseEntity<String>("Movie deleted", HttpStatus.OK);
    }

    // UPDATE
    @PutMapping("/update")
    public ResponseEntity<Movie> updateMovieById(@RequestParam Long id, @RequestBody Movie newMovie) {
        return new ResponseEntity<>(movieService.updateMovieById(id, newMovie), HttpStatus.OK);
    }

    /* 1 */
    @GetMapping("/titleNOTSANITIZED")
    public ResponseEntity<Movie> getMovieByTitle(@RequestParam String title) {
        return new ResponseEntity<>(movieService.getMovieByTitle(title), HttpStatus.OK);
    }

    /* 2 */
    @GetMapping("/title")
    public ResponseEntity<List<Movie>> getMovieBySanitizeTitle(@RequestParam String sanitizeTitle) {
        return new ResponseEntity<>(movieService.getMovieBySanitizeTitle(
                sanitizeTitle),
                HttpStatus.OK);
    }

}
