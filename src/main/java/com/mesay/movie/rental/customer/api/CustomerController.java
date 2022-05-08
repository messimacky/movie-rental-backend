package com.mesay.movie.rental.customer.api;

import com.mesay.movie.rental.customer.domain.service.CustomerService;
import com.mesay.movie.rental.customer.dto.CreateCustomerRequest;
import com.mesay.movie.rental.customer.dto.CustomerResponse;
import com.mesay.movie.rental.customer.dto.UpdateCustomerRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/customers")
public class CustomerController {

    final
    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerResponse> getAllCustomers()
    {
        return customerService.findAllCustomers();

    }

    @PostMapping
    public CustomerResponse saveCustomerDetails(@RequestBody CreateCustomerRequest customer)
    {
        return customerService.addCustomer(customer);
    }

    @GetMapping("/{id}")
    public CustomerResponse getSingleCustomer(@PathVariable Long id)
    {
        return  customerService.findById(id);
    }

    @PutMapping
    public CustomerResponse updateCustomerDetails(@RequestBody UpdateCustomerRequest updateCustomerRequest)
    {
        return customerService.updateCustomerRequest(updateCustomerRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCustomerById(@PathVariable Long id)
    {
        customerService.deleteById(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }


}
