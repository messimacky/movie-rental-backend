package com.mesay.movie.rental.customer.domain.service;


import com.mesay.movie.rental.customer.dto.CreateCustomerRequest;
import com.mesay.movie.rental.customer.dto.CustomerResponse;
import com.mesay.movie.rental.customer.dto.UpdateCustomerRequest;

import java.util.List;

public interface CustomerService {

    List<CustomerResponse> findAllCustomers();

     CustomerResponse addCustomer(CreateCustomerRequest createCustomerRequest);

     CustomerResponse findById(Long id);

     CustomerResponse updateCustomerRequest(UpdateCustomerRequest updateCustomerRequest);

    void deleteById(Long id);
}
