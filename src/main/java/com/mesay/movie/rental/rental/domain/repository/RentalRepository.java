package com.mesay.movie.rental.rental.domain.repository;

import com.mesay.movie.rental.rental.domain.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<Rental,Long> {
}
