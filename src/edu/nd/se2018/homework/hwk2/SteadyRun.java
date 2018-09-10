package edu.nd.se2018.homework.hwk2;

public class SteadyRun implements Strategy {
	
	public SteadyRun() {

	}
	
	public int getSpeed(double distance, int maxSpeed) {
		return (int)(maxSpeed*0.8); // 80% for whole race
	}

}
