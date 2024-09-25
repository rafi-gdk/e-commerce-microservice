package com.sonu.order.feign;

import com.sonu.order.beans.response.Customer;
import feign.Headers;
import jakarta.validation.constraints.Size;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customerService", url = "http://customer-deployment:9003", path = "/customer-service/customer")
@Headers({"Content-type", "application/json"})
public interface CustomerService {

    @GetMapping(value = "/getCustomer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Customer> getCustomer(@PathVariable("customerId") @Size(min = 8, max = 8, message = "CustomerId Length should be 8") String customerId);

}