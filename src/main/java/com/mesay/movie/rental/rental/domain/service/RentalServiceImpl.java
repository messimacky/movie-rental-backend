package com.mesay.movie.rental.rental.domain.service;

import com.mesay.movie.rental.customer.domain.entitiy.Customer;
import com.mesay.movie.rental.customer.domain.repository.CustomerRepository;
import com.mesay.movie.rental.movie.domain.entity.Movie;
import com.mesay.movie.rental.movie.domain.repository.MovieRepository;
import com.mesay.movie.rental.rental.domain.entity.Rental;
import com.mesay.movie.rental.rental.domain.repository.RentalRepository;
import com.mesay.movie.rental.rental.dto.MovieReturnResponse;
import com.mesay.movie.rental.rental.dto.RentRequest;
import com.mesay.movie.rental.rental.dto.RentalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalServiceImpl implements RentalService{

    @Autowired
    RentalRepository rentalRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    MovieRepository movieRepository;

    @Override
    public RentalResponse createRent(RentRequest rentRequest) {

        Customer customer = customerRepository.findById(rentRequest.getCustomerId())
                .orElseThrow(
                        () ->
                                new IllegalArgumentException(
                                        "customer doesn't exist please register"));

        Movie movie = movieRepository.findById(rentRequest.getMovieId())
                .orElseThrow(
                        () ->
                                new IllegalArgumentException(
                                        "movie doesn't exist"));

        LocalDate now = LocalDate.now();

        LocalDate expiryDate = now.plusDays(rentRequest.getTotalRentPeriod());

        Rental rental = new Rental();

        rental.setMovie(movie);

        rental.setCustomer(customer);

        rental.setRentalExpiry(expiryDate);

        rental.setTotalCost(rentRequest.getRentAmount());

        return new RentalResponse(rentalRepository.save(rental));
    }

    @Override
    public MovieReturnResponse returnMovie(Long rentId) {
        return rentalRepository.findById(rentId)
                .map(r -> {
                    if(r.getRentalExpiry().isBefore(LocalDate.now())){
                        return 10.0;
                    }
                    r.setReturned(true);
                    return null;
                })
                .map(MovieReturnResponse::new)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "invalid rent id"));
    }

    @Override
    public List<RentalResponse> getAllRent() {
        return rentalRepository.findAll()
                .stream()
                .map(RentalResponse::new)
                .collect(Collectors.toList());
    }
}
