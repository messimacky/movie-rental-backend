package com.mesay.movie.rental.movie.api;

import com.mesay.movie.rental.movie.domain.service.MovieService;
import com.mesay.movie.rental.movie.dto.CreateMovieRequest;
import com.mesay.movie.rental.movie.dto.MovieResponse;
import com.mesay.movie.rental.movie.dto.UpdateMovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping
    public MovieResponse addMovie(@RequestBody CreateMovieRequest createMovieRequest) {

        return movieService.addMovie(createMovieRequest);
    }
    @GetMapping("/{title}")
    public MovieResponse getMovieByTitle(@PathVariable String title){

        return movieService.findMovieByTitle(title);
    }

    @GetMapping
    public List<MovieResponse> getAllMovies(){

        return movieService.getAllMovies();
    }


    @PutMapping
    public MovieResponse updateMovie(@RequestBody UpdateMovieRequest updateMovieRequest){
        return movieService.updateMovie(updateMovieRequest);
    }

    @DeleteMapping ("/{id}")
    public void deleteMovie(@PathVariable Long id){

        movieService.deleteById(id);
    }

}
