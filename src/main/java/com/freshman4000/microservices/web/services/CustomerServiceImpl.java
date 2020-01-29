package com.freshman4000.microservices.web.services;

import com.freshman4000.microservices.repositories.CustomerRepository;
import com.freshman4000.microservices.web.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto getCustomerById(UUID id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        customerRepository.save(customerDto);
        return customerDto;
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        CustomerDto currentCustomer = customerRepository.findById(customerId).orElse(null);
        if (currentCustomer != null) {
            currentCustomer.setName(customerDto.getName());
            customerRepository.save(currentCustomer);
        }
    }

    @Override
    public void deleteCustomer(UUID customerId) {
    customerRepository.deleteById(customerId);
    }
}
