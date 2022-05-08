package com.mesay.movie.rental.movie.domain.service;

import com.mesay.movie.rental.movie.dto.CreateMovieRequest;
import com.mesay.movie.rental.movie.dto.MovieResponse;
import com.mesay.movie.rental.movie.dto.UpdateMovieRequest;

import java.util.List;

public interface MovieService {

    MovieResponse addMovie(CreateMovieRequest createMovieRequest);

    MovieResponse findMovieByTitle(String title);

    MovieResponse updateMovie(UpdateMovieRequest updateMovieRequest);

    void deleteById(Long id);

    List<MovieResponse> getAllMovies();
}




