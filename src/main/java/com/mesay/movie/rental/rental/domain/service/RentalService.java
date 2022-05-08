package com.mesay.movie.rental.rental.domain.service;

import com.mesay.movie.rental.rental.dto.MovieReturnResponse;
import com.mesay.movie.rental.rental.dto.RentRequest;
import com.mesay.movie.rental.rental.dto.RentalResponse;

import java.util.List;

public interface RentalService {

    RentalResponse createRent(RentRequest rentRequest);

    MovieReturnResponse returnMovie(Long rentId);

    List<RentalResponse> getAllRent();
}
