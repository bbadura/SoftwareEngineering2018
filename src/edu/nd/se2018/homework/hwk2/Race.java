package edu.nd.se2018.homework.hwk2;

import edu.nd.se2018.homework.hwk2.Horse;
import java.util.*;

public class Race {
	
	ArrayList<Horse> horses = new ArrayList<Horse>();
	int currTime = 0;
	boolean hasWon = false;
	
	// make a new Race object
	public Race() {
		
	}
	
	public void addHorse(Horse horse) {
		horses.add(horse);
	}
	
	public String performRace(boolean verbose) {
		// loop until the finish line has been crossed
		while (!hasWon) {
			for (int i=0; i < 5; i++) { // loop through all horses
				horses.get(i).step();
				hasWon = horses.get(i).checkWinner();
				if (verbose)
					horses.get(i).display();
				if (hasWon) {
					System.out.println(horses.get(i).getName() + " has won!");
					return horses.get(i).getName();
				}
			}
			if (verbose)
				System.out.println();
		}
		return "";
	}
}
