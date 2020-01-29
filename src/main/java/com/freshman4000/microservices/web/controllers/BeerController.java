package com.freshman4000.microservices.web.controllers;

import com.freshman4000.microservices.web.model.Beer;
import com.freshman4000.microservices.web.services.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return new ResponseEntity<>(beerService.getBearById(beerUUID), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<HttpHeaders> handlePost(@RequestBody Beer beer) {
        beerService.saveBeer(beer);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v1/beer/" + beer.getId());
        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }
    @DeleteMapping("/{beerUUID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable("beerUUID") UUID beerUUID) {
        beerService.deleteBeerById(beerUUID);
    }
    @PutMapping("/{beerUUID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handlePut(@PathVariable("beerUUID") UUID beerUUID, @RequestBody Beer beer) {
        beerService.updateBeerById(beerUUID, beer);
    }
}
