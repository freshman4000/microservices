package com.freshman4000.microservices.web.services;

import com.freshman4000.microservices.web.model.Beer;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public Beer getBearById(UUID id) {
        return Beer.builder()
                .id(UUID.randomUUID())
                .beerName("Corona")
                .beerStyle("Mexican")
                .build();
    }
}
