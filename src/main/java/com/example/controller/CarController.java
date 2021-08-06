package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Car;
import com.example.repository.CarRepository;

@RestController
public class CarController {
	
	@Autowired
	private CarRepository carRepository;

	@PostMapping("/saveCar")
	public ResponseEntity<String> saveCar(@RequestBody Car car) {
		Car car2 = carRepository.findByCarId(car.getCarId()).orElse(null);
		if(car2 != null){
			return new ResponseEntity<String>( "Already Exists with same Car Id", HttpStatus.CONFLICT);
		}
		carRepository.save(car);
		return new ResponseEntity<String>( "Saved Car", HttpStatus.CREATED);
	}
	
	@PostMapping("/editCar")
	public ResponseEntity<String> editCar(@RequestParam Long id, @RequestBody Car car) {
		Car car2 = carRepository.findByCarId(id).orElse(null);
		if(car2 == null) {
			return new ResponseEntity<String>( "Car with give Id does not exist", HttpStatus.CONFLICT);
		}
		car.setCarId(id);
		carRepository.save(car);
		return new ResponseEntity<String>( "Edited Car", HttpStatus.OK);
	}
	
	@GetMapping("/deleteCar")
	public ResponseEntity<String> deleteCar(@RequestParam Long id) {
		Optional<Car> car2 = carRepository.findByCarId(id);
		
		if(car2 == null) {
			return new ResponseEntity<String>( "Car with give Id does not exist", HttpStatus.CONFLICT);
		}
		
		carRepository.deleteById(id);
		return new ResponseEntity<String>( "Deleted Car", HttpStatus.OK);
	}
	
	@GetMapping("/getCars")
	public ResponseEntity<List<?>> getAllCars() {
		return new ResponseEntity<List<?>>(carRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/getCar")
	public ResponseEntity<?> getCarById(@RequestParam Long id) {
		
		Car car = carRepository.findByCarId(id).orElse(null);
		if(car == null){
			return new ResponseEntity<String>( "Car does not exists with given Car Id", HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Car>(car , HttpStatus.OK);
	}
	
//	@PutMapping("/update")
//	public ResponseEntity<?> updateSeries(@RequestBody Series series) {
//	      //System.out.println("inside update series");  
//		  Series series2 = seriesRepository.findById(series.getId()).orElse(null);
//		  
//			if(series2 == null) {
//				return new ResponseEntity<String>( "Series with given Id does not exist", HttpStatus.CONFLICT);
//			}
//			series.setId(series2.getId());
//			seriesRepository.save(series);
//			return new ResponseEntity<String>( "Updated Series", HttpStatus.OK);
//
//	  }
}
