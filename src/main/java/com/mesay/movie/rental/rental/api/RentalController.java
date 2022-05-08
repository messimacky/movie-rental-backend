package com.mesay.movie.rental.rental.api;

import com.mesay.movie.rental.rental.domain.service.RentalService;
import com.mesay.movie.rental.rental.dto.MovieReturnResponse;
import com.mesay.movie.rental.rental.dto.RentRequest;
import com.mesay.movie.rental.rental.dto.RentalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    @Autowired
    RentalService rentalService;

    @PostMapping
   public RentalResponse createRent(@RequestBody RentRequest rentRequest){
        return rentalService.createRent(rentRequest);
    }

    @GetMapping
    public List<RentalResponse> getAllRentals(){

        return rentalService.getAllRent();
    }

    @PutMapping ("/{id}")
    public MovieReturnResponse returnMovie(@PathVariable Long id){

        return  rentalService.returnMovie(id);
    }
}
