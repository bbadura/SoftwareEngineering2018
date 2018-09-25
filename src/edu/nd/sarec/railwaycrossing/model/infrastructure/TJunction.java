package edu.nd.sarec.railwaycrossing.model.infrastructure;

import java.util.ArrayList;

import edu.nd.sarec.railwaycrossing.model.vehicles.Car;

public class TJunction {
	private ArrayList<Car> westHigh = new ArrayList<Car>();
	private ArrayList<Car> westLow = new ArrayList<Car>();
	private ArrayList<Car> eastHigh = new ArrayList<Car>();
	private ArrayList<Car> eastLow = new ArrayList<Car>();
	private ArrayList<Car> eastWest = new ArrayList<Car>();
	
	// Insert car onto western Highway
	public void insertWestHigh(Car car) {
		westHigh.add(car);
		if (westHigh.size() > 1) {
			westHigh.get(westHigh.size()-2).addObserver(westHigh.get(westHigh.size()-1));
		}
	}
	
	// Insert car onto eastern highway
	public void insertEastHigh(Car car) {
		eastHigh.add(car);
		if (eastHigh.size() > 1) {
			eastHigh.get(eastHigh.size()-2).addObserver(eastHigh.get(eastHigh.size()-1));
		}
	}

	// Insert car into middle connector
	public void insertEastWest(Car car) {
		eastWest.add(car);
		if (eastWest.size() > 1) {
			eastWest.get(eastWest.size()-2).addObserver(eastWest.get(eastWest.size()-1));
		}
	}
	
	public void transferWestLow(Car car) {
		westLow.add(westHigh.get(0));
		westHigh.remove(0);
		if (westLow.size() > 1) {
			westLow.get(westLow.size()-2).addObserver(westLow.get(westLow.size()-1));
		}
	}
	
	public void transferEastLow(Car car) {
		eastLow.add(eastHigh.get(0));
		eastHigh.remove(0);
	}
}
