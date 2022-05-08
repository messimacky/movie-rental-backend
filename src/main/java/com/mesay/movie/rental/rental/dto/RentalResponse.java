package com.mesay.movie.rental.rental.dto;

import com.mesay.movie.rental.rental.domain.entity.Rental;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentalResponse {

    private Long rentalId;
    private Long customerId;
    private String customerFirstName;
    private String customerLastName;
    private String movieTitle;
    private Long movieId;
    private Double rentAmount;
    private String rentDate;
    private String rentalExpiry;
    private Boolean isReturned;

    public RentalResponse(Rental rental){
        this.rentalId = rental.getRentalId();
        this.customerFirstName = rental.getCustomer().getFirstName();
        this.customerLastName = rental.getCustomer().getLastName();
        this.customerId = rental.getCustomer().getId();
        this.movieTitle = rental.getMovie().getTitle();
        this.movieId = rental.getMovie().getId();
        this.rentAmount = rental.getTotalCost();
        this.rentDate = rental.getCreationDate().toString();
        this.rentalExpiry = rental.getRentalExpiry().toString();
        this.isReturned = rental.isReturned();
    }
}
