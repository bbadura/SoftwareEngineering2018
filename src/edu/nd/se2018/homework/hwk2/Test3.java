package edu.nd.se2018.homework.hwk2;
import org.junit.Test;

public class Test3 {
	@Test
	public void test() {
		// make 5 new horses and assign jockey strategy
		Horse horse1 = new Horse(40,"Albert",new EarlySprint());
		Horse horse2 = new Horse(50,"Bobby",new EarlySprint());
		Horse horse3 = new Horse(60,"Carmel",new EarlySprint());
		Horse horse4 = new Horse(70,"Doug",new EarlySprint());
		Horse horse5 = new Horse(80,"Ethan",new EarlySprint());
		
		// create a new race
		Race race = new Race();
		
		// add your horses to the race
		race.addHorse(horse1);
		race.addHorse(horse2);
		race.addHorse(horse3);
		race.addHorse(horse4);
		race.addHorse(horse5);
		
		
		// This test ensures that given the same strategy, the fastest horse will indeed win
		assert(race.performRace(false)=="Ethan");
	}
}