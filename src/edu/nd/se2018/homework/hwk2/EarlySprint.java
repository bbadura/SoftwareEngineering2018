package edu.nd.se2018.homework.hwk2;

public class EarlySprint implements Strategy {

	public EarlySprint() {

	}
	
	public int getSpeed(double distance, int maxSpeed) {
		if (distance <= 2) { // full speed for first 2 miles
			return maxSpeed;
		}
		else { // 75% for remainder
			return (int)(maxSpeed*0.75);
		}
	}
}
