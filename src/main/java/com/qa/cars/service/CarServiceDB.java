package com.qa.cars.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.cars.domain.Car;
import com.qa.cars.repo.CarRepo;

@Service
public class CarServiceDB implements CarService {

	private CarRepo repo;

	@Autowired
	public CarServiceDB(CarRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Car createCar(Car car) {
		Car created = this.repo.save(car);
		return created;
	}

	@Override
	public List<Car> getAllCars() {
		return this.repo.findAll();
	}

	@Override
	public Car getCar(Integer id) {
		Optional<Car> found = this.repo.findById(id);
		return found.get();
	}

	@Override
	public List<Car> getAllCarsByMake(String make) {
		List<Car> found = this.repo.findByMakeIgnoreCase(make);
		return found;
	}

	@Override
	public Car replaceCar(Integer id, Car newCar) {
		Car existing = this.repo.findById(id).get();

		existing.setMake(newCar.getMake());
		existing.setNumDoors(newCar.getNumDoors());
		existing.setColour(newCar.getColour());
		existing.setMiles(newCar.getMiles());

		Car updated = this.repo.save(existing);
		return updated;
	}

	@Override
	public void removeCar(Integer id) {
		this.repo.deleteById(id);

	}

}
