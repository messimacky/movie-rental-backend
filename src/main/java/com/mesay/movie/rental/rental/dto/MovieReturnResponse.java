package com.mesay.movie.rental.rental.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieReturnResponse {

    Double penaltyAmount;

    public MovieReturnResponse(Double penaltyAmount) {
        this.penaltyAmount = penaltyAmount;
    }
}
