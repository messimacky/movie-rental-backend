package com.mesay.movie.rental.rental.domain.entity;

import com.mesay.movie.rental.Auditable;
import com.mesay.movie.rental.customer.domain.entitiy.Customer;
import com.mesay.movie.rental.movie.domain.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rental extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentalId;
    @OneToOne
    private Customer customer;
    @OneToOne
    private Movie movie;
    private LocalDate rentalExpiry;
    private Double totalCost;
    private boolean isReturned;
}

