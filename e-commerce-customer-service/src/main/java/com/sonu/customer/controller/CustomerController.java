package com.sonu.customer.controller;


import com.sonu.customer.beans.request.CustomerRequest;
import com.sonu.customer.beans.response.CustomerResponse;
import com.sonu.customer.service.CustomerService;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@Validated
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/getCustomer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable("customerId") @Size(min = 8, max = 8, message = "CustomerId Length should be 8") String customerId) {
        return new ResponseEntity<>(customerService.getCustomer(customerId), HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/getAllCustomers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/addCustomer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerResponse> addCustomer(@Validated @RequestBody CustomerRequest CustomerRequest) {
        return new ResponseEntity<>(customerService.addCustomer(CustomerRequest), HttpStatus.CREATED);
    }

    @PutMapping(value = "/updateCustomer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerResponse> updateCustomer(@Validated @RequestBody CustomerRequest CustomerRequest) {
        return new ResponseEntity<>(customerService.updateCustomer(CustomerRequest), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/deleteCustomer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteCustomer(@PathVariable("customerId") @Size(min = 8, max = 8, message = "CustomerId Length should be 8") String customerId) {
        return new ResponseEntity<>(customerService.deleteCustomer(customerId), HttpStatus.ACCEPTED);
    }
}
