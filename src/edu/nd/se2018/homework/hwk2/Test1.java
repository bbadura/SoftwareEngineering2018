package edu.nd.se2018.homework.hwk2;
import org.junit.Test;

public class Test1 {
	@Test
	public void test() {
		// make 5 new horses and assign jockey strategy
		Horse horse1 = new Horse(40,"Albert",new EarlySprint());
		Horse horse2 = new Horse(70,"Bobby",new SteadyRun());
		Horse horse3 = new Horse(60,"Carmel",new SlowStart());
		Horse horse4 = new Horse(70,"Doug",new EarlySprint());
		Horse horse5 = new Horse(90,"Ethan",new SteadyRun());
		
		// create a new race
		Race race = new Race();
		
		// add your horses to the race
		race.addHorse(horse1);
		race.addHorse(horse2);
		race.addHorse(horse3);
		race.addHorse(horse4);
		race.addHorse(horse5);
		
		// this is a general test, where speeds and strategies are distributed. The fastest max speed mixed with steady run wins.
		assert(race.performRace(false)=="Ethan");
	}
}
