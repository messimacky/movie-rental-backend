package com.mesay.movie.rental.customer.dto;

import com.mesay.movie.rental.customer.domain.entitiy.Customer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String phone;
    private String address;
    private String email;
    private String creationDate;
    private String updatedDate;
    private String createdBy;
    private String lastUpdatedBy;

    public CustomerResponse(Customer customer){

        this.id = customer.getId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.username = customer.getUsername();
        this.address = customer.getAddress();
        this.phone = customer.getPhone();
        this.email = customer.getEmail();
        this.creationDate = customer.getCreationDate().toString();
        this.updatedDate = customer.getLastModifiedDate().toString();
        this.createdBy = customer.getCreatedBy();
        this.lastUpdatedBy = customer.getLastModifiedBy();

    }
}

