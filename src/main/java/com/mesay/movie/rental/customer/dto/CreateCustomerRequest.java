package com.mesay.movie.rental.customer.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phone;
    private String username;
}
