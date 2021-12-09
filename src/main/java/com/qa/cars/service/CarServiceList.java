package com.qa.cars.service;

import java.util.ArrayList;
import java.util.List;

import com.qa.cars.domain.Car;

public class CarServiceList implements CarService {

	private List<Car> cars = new ArrayList<>();

	@Override
	public Car createCar(Car car) {
		this.cars.add(car);
		Car created = this.cars.get(this.cars.size() - 1);
		return created;
	}

	@Override
	public List<Car> getAllCars() {
		return this.cars;
	}

	@Override
	public List<Car> getAllCarsByMake(String make) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car getCar(Integer id) {
		return this.cars.get(id);
	}

	@Override
	public Car replaceCar(Integer id, Car newCar) {
		Car found = this.cars.set(id, newCar);
		return found;
	}

	@Override
	public void removeCar(Integer id) {
		this.cars.remove(id.intValue());
	}

}
