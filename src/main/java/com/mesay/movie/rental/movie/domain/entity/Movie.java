package com.mesay.movie.rental.movie.domain.entity;

import com.mesay.movie.rental.Auditable;
import com.mesay.movie.rental.movie.dto.MovieGenre;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String language;
    private String title;
    private double price;
    private String year;
    @Enumerated(EnumType.STRING)
    private MovieGenre genre;

}
