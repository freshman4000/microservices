package com.freshman4000.microservices.web.controllers;

import com.freshman4000.microservices.web.model.CustomerDto;
import com.freshman4000.microservices.web.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerUUID}")
    public ResponseEntity<CustomerDto> getCustomerByUUID(@PathVariable("customerUUID") UUID customerUUID) {
        return new ResponseEntity<>(customerService.getCustomerById(customerUUID), HttpStatus.OK);
    }
    @PutMapping("/{customerUUID}")
    public ResponseEntity<HttpStatus> handlePut(@PathVariable("customerUUID") UUID customerUUID, @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(customerUUID, customerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping
    public ResponseEntity<HttpHeaders> handlePost(@RequestBody CustomerDto customerDto){
        CustomerDto savedCustomer = customerService.saveCustomer(customerDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v1/customer/" + savedCustomer.getId());
        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }
    @DeleteMapping("/{customerUUID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable UUID customerUUID) {
        customerService.deleteCustomer(customerUUID);
    }

}
