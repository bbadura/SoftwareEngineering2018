package edu.nd.se2018.homework.hwk2;

public class SlowStart implements Strategy {

	public SlowStart() {

	}
	
	public int getSpeed(double distance, int maxSpeed) {
		if (distance <= 6) { // 75% for first 6 miles
			return (int)(maxSpeed*0.75);
		}
		else if (distance <= 9){ // 90% for miles 7-9
			return (int)(maxSpeed*0.9);
		}
		else { // 100% for last mile
			return maxSpeed;
		}
	}

}
