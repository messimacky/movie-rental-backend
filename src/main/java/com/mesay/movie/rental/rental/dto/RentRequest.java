package com.mesay.movie.rental.rental.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentRequest {
    private Long customerId;
    private Long movieId;
    private Double rentAmount;
    private Long totalRentPeriod;
}
