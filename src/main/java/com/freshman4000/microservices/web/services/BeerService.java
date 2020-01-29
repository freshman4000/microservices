package com.freshman4000.microservices.web.services;

import com.freshman4000.microservices.web.model.Beer;

import java.util.UUID;

public interface BeerService {
    Beer getBearById(UUID id);
    Beer saveBeer(Beer beer);
    void updateBeerById(UUID id, Beer beer);
    void deleteBeerById(UUID id);


}
