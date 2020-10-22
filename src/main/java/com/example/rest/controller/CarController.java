package com.example.rest.controller;

import com.example.rest.model.Car;
import com.example.rest.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CarController {

    CarsRepository carsRepository;

    @Autowired
    public CarController(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    //-> http://localhost:8080/rest/car?id=1
    @RequestMapping("/rest/car")
    public Optional<?> find(@RequestParam(value = "id") Long id) {
        if (carsRepository.findById(id).isPresent()) {
            return carsRepository.findById(id);
        }
        return Optional.of("Car not found");
    }

    //  POST -> {"modelName":"VW2"}  to INSERT entry
    @PostMapping("/rest/car")
    public ResponseEntity<?> addCar(@RequestBody Car car) {
        Car newCar = new Car(car.getId(), car.getModelName());
        carsRepository.save(newCar);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //-> http://localhost:8080/rest/allcars
    @RequestMapping("/rest/allcars")
    public Iterable<Car> showAll() {
        return carsRepository.findAll();
    }
}