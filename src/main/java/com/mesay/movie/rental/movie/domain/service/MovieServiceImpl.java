package com.mesay.movie.rental.movie.domain.service;

import com.mesay.movie.rental.movie.domain.entity.Movie;
import com.mesay.movie.rental.movie.domain.repository.MovieRepository;
import com.mesay.movie.rental.movie.dto.CreateMovieRequest;
import com.mesay.movie.rental.movie.dto.MovieResponse;
import com.mesay.movie.rental.movie.dto.UpdateMovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;

        @Override
    public MovieResponse addMovie(CreateMovieRequest createMovieRequest) {

        Movie movie = new Movie();

        movie.setGenre(createMovieRequest.getGenre());
        movie.setLanguage(createMovieRequest.getLanguage());
        movie.setPrice(createMovieRequest.getPrice());
        movie.setYear(createMovieRequest.getYear());
        movie.setLanguage(createMovieRequest.getLanguage());
        movie.setTitle(createMovieRequest.getTitle());

        return new MovieResponse(movieRepository.save(movie));
    }

    @Override
    public MovieResponse findMovieByTitle(String title) {

       return movieRepository.findMovieByTitle(title)
                .map(MovieResponse::new)
                .orElseThrow(
                        () -> new IllegalArgumentException(
                                "movie with ->"+title+" doesn't exist"));
    }

    @Override
    public MovieResponse updateMovie(UpdateMovieRequest updateMovieRequest) {

           return movieRepository.findById(updateMovieRequest.getMovieId())
                    .map(m -> {
                        m.setTitle(updateMovieRequest.getTitle());
                        m.setYear(updateMovieRequest.getYear());
                        m.setPrice(updateMovieRequest.getPrice());
                        m.setLanguage(updateMovieRequest.getLanguage());
                        m.setGenre(updateMovieRequest.getGenre());
                        return new MovieResponse(movieRepository.save(m));
                    }).orElseThrow(
                            () -> new IllegalArgumentException(
                                    "movie with ->"+updateMovieRequest.getMovieId()+" doesn't exist")
                    );
    }

    @Override
    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public List<MovieResponse> getAllMovies() {
        return movieRepository.findAll()
                .stream().map(MovieResponse::new)
                .collect(Collectors.toList());
    }
}
