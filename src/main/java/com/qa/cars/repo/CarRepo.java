package com.qa.cars.repo;

import org.springframework.stereotype.Repository;

import com.qa.cars.domain.Car;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CarRepo extends JpaRepository<Car, Integer> {
	
	List<Car> findByMakeIgnoreCase(String make);
	List<Car> findByNumDoors(Integer numDoors);
	List<Car> findByColour(String colour);
	List<Car> findByMiles(Long miles);

}
