package edu.nd.se2018.homework.hwk2;

public class Horse {
	int maxSpeed;
	String name = new String();
	Strategy strategy;
	double currPosition = 0;
	int currSpeed = 0;
	
	// constructor
	public Horse(int speed, String inputName, Strategy inputStrategy) {
		maxSpeed = speed;
		name = inputName;
		strategy = inputStrategy;
	}
	
	// figure out current position after a minute has passed
	public void step() {
		currSpeed = strategy.getSpeed(currPosition, maxSpeed);
		currPosition += (currSpeed/60.0);
	}
	
	// check to see if the finish line has been crossed
	public boolean checkWinner() {
		if (currPosition >= 10) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// print out updates
	public void display() {
		System.out.println(name + " has run " + currPosition + " miles.");
	}
	
	//////////////////////
	// helper functions //
	//////////////////////
	
	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	public String getName() {
		return name;
	}
	
	public Strategy getStrategy() {
		return strategy;
	}
	
	public void setMaxSpeed(int speed) {
		maxSpeed = speed;
	}
	
	public void setName(String inputName) {
		name = inputName;
	}
	
	public void setStrategy(Strategy inputStrategy) {
		strategy = inputStrategy;
	}
	
}
