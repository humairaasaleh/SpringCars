package com.qa.cars.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String make;

	private int numDoors;
	private String colour;
	private long miles;

	public Car() {
		super();
	}

	public Car(String make, int numDoors, String colour, long miles) {
		super();
		this.make = make;
		this.numDoors = numDoors;
		this.colour = colour;
		this.miles = miles;
	}

	public Car(Integer id, String make, int numDoors, String colour, long miles) {
		super();
		this.id = id;
		this.make = make;
		this.numDoors = numDoors;
		this.colour = colour;
		this.miles = miles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public int getNumDoors() {
		return numDoors;
	}

	public void setNumDoors(int numDoors) {
		this.numDoors = numDoors;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public long getMiles() {
		return miles;
	}

	public void setMiles(long miles) {
		this.miles = miles;
	}

	@Override
	public String toString() {
		return "Car [make=" + make + ", numDoors=" + numDoors + ", colour=" + colour + ", miles=" + miles + "]";
	}
}
