package com.freshman4000.microservices.web.services;

import com.freshman4000.microservices.web.model.Beer;

import java.util.UUID;

public interface BeerService {
    Beer getBearById(UUID id);
}
