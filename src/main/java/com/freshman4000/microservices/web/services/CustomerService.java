package com.freshman4000.microservices.web.services;

import com.freshman4000.microservices.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface CustomerService {
CustomerDto getCustomerById(UUID id);
CustomerDto saveCustomer(CustomerDto customerDto);
void updateCustomer(UUID customerId, CustomerDto customerDto);
void deleteCustomer(UUID customerId);
}
