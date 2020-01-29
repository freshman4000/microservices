package com.freshman4000.microservices.web.services;

import com.freshman4000.microservices.repositories.BeerRepository;
import com.freshman4000.microservices.web.model.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {

    private BeerRepository beerRepository;

    @Autowired
    public void setCustomerRepository(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public Beer getBearById(UUID id) {
        return beerRepository.findById(id).orElse(null);
    }

    @Override
    public Beer saveBeer(Beer beer) {
        beerRepository.save(beer);
        return beer;
    }

    @Override
    public void updateBeerById(UUID id, Beer beer) {
        Optional<Beer> optBeer = beerRepository.findById(id);
        Beer currentBeer = optBeer.orElse(null);
        if (currentBeer != null) {
        currentBeer.setId(beer.getId());
        currentBeer.setBeerName(beer.getBeerName());
        currentBeer.setBeerStyle(beer.getBeerStyle());
        currentBeer.setUpc(beer.getUpc());
        beerRepository.save(currentBeer);
        }
    }

    @Override
    public void deleteBeerById(UUID id) {
    beerRepository.deleteById(id);
    }
}
