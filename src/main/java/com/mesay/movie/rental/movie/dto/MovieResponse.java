package com.mesay.movie.rental.movie.dto;

import com.mesay.movie.rental.movie.domain.entity.Movie;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieResponse {

    private Long movieId;
    private String title;
    private String genre;
    private String year;
    private Double price;
    private String language;
    private String createdDate;
    private String createdBy;

    public MovieResponse(Movie movie){
        this.movieId = movie.getId();
        this.title = movie.getTitle();
        this.genre = movie.getGenre().toString();
        this.year = movie.getYear();
        this.price = movie.getPrice();
        this.language = movie.getLanguage();
        this.createdBy = movie.getCreatedBy();
        this.createdDate = movie.getCreationDate().toString();
    }
}
