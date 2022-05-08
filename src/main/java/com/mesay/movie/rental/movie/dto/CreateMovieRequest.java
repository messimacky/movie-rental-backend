package com.mesay.movie.rental.movie.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMovieRequest {

    private String title;
    private MovieGenre genre;
    private String year;
    private Double price;
    private String language;
}
