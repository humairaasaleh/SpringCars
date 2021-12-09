package com.qa.cars.service;

import java.util.List;

import com.qa.cars.domain.Car;

public interface CarService {

	Car createCar(Car car);

	List<Car> getAllCars();

	List<Car> getAllCarsByMake(String make);

	Car getCar(Integer id);

	Car replaceCar(Integer id, Car newCar);

	void removeCar(Integer id);
}
