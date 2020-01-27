package com.freshman4000.microservices.web.controllers;

import com.freshman4000.microservices.web.model.Beer;
import com.freshman4000.microservices.web.services.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final BeerService beerService;

    @Autowired
    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerUUID}")
    public ResponseEntity<Beer> getBeer(@PathVariable("beerUUID") UUID beerUUID) {
        return new ResponseEntity<Beer>(beerService.getBearById(beerUUID), HttpStatus.OK);
    }
}
