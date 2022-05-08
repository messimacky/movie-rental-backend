package com.mesay.movie.rental.customer.domain.service;


import com.mesay.movie.rental.customer.domain.entitiy.Customer;
import com.mesay.movie.rental.customer.domain.exception.CustomerServiceException;
import com.mesay.movie.rental.customer.domain.repository.CustomerRepository;
import com.mesay.movie.rental.customer.dto.CreateCustomerRequest;
import com.mesay.movie.rental.customer.dto.CustomerResponse;
import com.mesay.movie.rental.customer.dto.UpdateCustomerRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerResponse> findAllCustomers() {
         return customerRepository.findAll().stream()
                 .map(CustomerResponse::new)
                 .collect(Collectors.toList());
    }

    @Override
    public CustomerResponse addCustomer(CreateCustomerRequest createCustomerRequest) {

        Customer customer = new Customer();

        customer.setAddress(createCustomerRequest.getAddress());

        customer.setEmail(createCustomerRequest.getEmail());

        customer.setFirstName(createCustomerRequest.getFirstName());

        customer.setPhone(createCustomerRequest.getPhone());

        customer.setLastName(createCustomerRequest.getLastName());

        customer.setUsername(createCustomerRequest.getUsername());

        Customer customerManaged = customerRepository.save(customer);

        return new CustomerResponse(customerManaged);
    }

    @Override
    public CustomerResponse findById(Long id) {
        return customerRepository.findById(id)
                .map(CustomerResponse::new)
                .orElseThrow(
                        () ->
                                new CustomerServiceException(
                                        "customer doesn't exist",
                                        CustomerServiceException.CUSTOMER_DOESNT_EXISTS));

    }

    @Override
    public CustomerResponse updateCustomerRequest(UpdateCustomerRequest updateCustomerRequest) {

        return customerRepository.findById(updateCustomerRequest.getCustomerId())
                .map(c -> {
                    c.setAddress(updateCustomerRequest.getAddress());
                    c.setEmail(updateCustomerRequest.getEmail());
                    c.setPhone(updateCustomerRequest.getPhone());
                    c.setUsername(updateCustomerRequest.getUsername());
                    c.setFirstName(updateCustomerRequest.getFirstName());
                    c.setLastName(updateCustomerRequest.getLastName());
                    return new CustomerResponse(customerRepository.save(c));
                }).orElseThrow(() ->
                        new CustomerServiceException(
                                "customer doesn't exist",
                                CustomerServiceException.CUSTOMER_DOESNT_EXISTS)
                );
    }


    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}
