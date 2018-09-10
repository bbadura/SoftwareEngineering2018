package edu.nd.se2018.homework.hwk2;

import edu.nd.se2018.homework.hwk2.Race;

public class Main {
	public static void main(String[] args) {
		
		// make 5 new horses and assign jockey strategy
		Horse horse1 = new Horse(40,"Albert",new EarlySprint());
		Horse horse2 = new Horse(40,"Bobby",new SteadyRun());
		Horse horse3 = new Horse(40,"Carmel",new SlowStart());
		Horse horse4 = new Horse(40,"Doug",new EarlySprint());
		Horse horse5 = new Horse(40,"Ethan",new SteadyRun());
		
		// create a new race
		Race race = new Race();
		
		// add your horses to the race
		race.addHorse(horse1);
		race.addHorse(horse2);
		race.addHorse(horse3);
		race.addHorse(horse4);
		race.addHorse(horse5);
		
		// run race, output in displayed to console. Input argument is verbosity.
		// true if you want updates for every minute
		// false if you only want the final result
		race.performRace(false);
	}
}
