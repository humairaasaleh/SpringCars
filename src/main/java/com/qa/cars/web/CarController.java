package com.qa.cars.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.cars.domain.Car;
import com.qa.cars.service.CarService;

@RestController
public class CarController {

	private CarService service;

	@Autowired

	public CarController(CarService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create") // 201
	public ResponseEntity<Car> createCar(@RequestBody Car car) {
		Car created = this.service.createCar(car);
		ResponseEntity<Car> response = new ResponseEntity<Car>(created, HttpStatus.CREATED);
		return response;
	}

	@GetMapping("/getAll") // 200
	public ResponseEntity<List<Car>> getAllCars() {
		return ResponseEntity.ok(this.service.getAllCars());
	}

	@GetMapping("/get/{id}") // 200
	public Car getCar(@PathVariable Integer id) {
		return this.service.getCar(id);
	}

	@GetMapping("/getByMake/{make}")
	public ResponseEntity<List<Car>> getCarByType(@PathVariable String make) {
		List<Car> found = this.service.getAllCarsByMake(make);
		return ResponseEntity.ok(found);
	}

	@PutMapping("/replace/{id}") // 202
	public ResponseEntity<Car> replaceCar(@PathVariable Integer id, @RequestBody Car newCar) {
		Car body = this.service.replaceCar(id, newCar);
		ResponseEntity<Car> response = new ResponseEntity<Car>(body, HttpStatus.ACCEPTED);
		return response;
	}

	@DeleteMapping("/remove/{id}") // 204
	public ResponseEntity<?> removeCar(@PathVariable Integer id) {
		this.service.removeCar(id);
		return new ResponseEntity<Car>(HttpStatus.NO_CONTENT);
	}
}