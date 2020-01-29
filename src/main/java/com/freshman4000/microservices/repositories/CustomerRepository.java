package com.freshman4000.microservices.repositories;

import com.freshman4000.microservices.web.model.CustomerDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CustomerRepository extends CrudRepository<CustomerDto, UUID> {
}
