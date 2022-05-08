package com.mesay.movie.rental.customer.domain.repository;

import com.mesay.movie.rental.customer.domain.entitiy.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findCustomerByEmail(String email);

    @Query("SELECT C.phone FROM Customer C WHERE C.email =: email")
    Optional<String> findUserPhoneNumberEmail(String email);

}
