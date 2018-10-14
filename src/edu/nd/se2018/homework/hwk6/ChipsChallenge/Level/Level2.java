package edu.nd.se2018.homework.hwk6.ChipsChallenge.Level;


import edu.nd.se2018.homework.hwk6.ChipsChallenge.Chip;
import edu.nd.se2018.homework.hwk6.ChipsChallenge.ChipGate;
import edu.nd.se2018.homework.hwk6.ChipsChallenge.Door;
import edu.nd.se2018.homework.hwk6.ChipsChallenge.Key;
import edu.nd.se2018.homework.hwk6.ChipsChallenge.Portal;
import edu.nd.se2018.homework.hwk6.ChipsChallenge.Wall;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class Level2 extends ChipsBoard{
	Portal portal;

	@Override
	public void buildElements(ObservableList<Node> root) {
		
		System.out.println("building level 2");
		
		// Build Walls
				Wall wall = new Wall(this, root);
				wall.buildStraightWall(0, 3, 9, 3);
				wall.buildStraightWall(15, 21, 24, 21);
				wall.buildStraightWall(3, 0, 3, 3);
				wall.buildStraightWall(21, 21, 21, 24);
				wall.buildStraightWall(4, 6, 4, 12);
				wall.buildStraightWall(5, 6, 5, 12);
				wall.buildStraightWall(19, 12, 19, 18);
				wall.buildStraightWall(20, 12, 20, 18);
				wall.buildStraightWall(0, 23, 9, 23);
				wall.buildStraightWall(2, 19, 11, 19);
				wall.buildStraightWall(4, 15, 13, 15);
				wall.buildStraightWall(11, 9, 20, 9);
				wall.buildStraightWall(13, 5, 22, 5);
				wall.buildStraightWall(15, 1, 24, 1);
				
				// Place Keys and Doors
				// Blue key/door pair
				Key blueKey = new Key(this, root, "blue");
				blueKey.placeKey(7, 10);
				this.man.addObserver(blueKey);
				Door blueDoor = new Door(this, root, "blue", blueKey);
				blueDoor.placeDoor(3, 1);
				this.man.addObserver(blueDoor);
				blueDoor.addObserver(wall);
				// Red key/door pair
				Key redKey = new Key(this, root, "red");
				redKey.placeKey(24, 9);
				this.man.addObserver(redKey);
				Door redDoor = new Door(this, root, "red", redKey);
				redDoor.placeDoor(3, 24);
				this.man.addObserver(redDoor);
				redDoor.addObserver(wall);
				// Yellow key/door pair
				Key yellowKey = new Key(this, root, "yellow");
				yellowKey.placeKey(0, 20);
				this.man.addObserver(yellowKey);
				Door yellowDoor = new Door(this, root, "yellow", yellowKey);
				yellowDoor.placeDoor(21, 0);
				this.man.addObserver(yellowDoor);
				yellowDoor.addObserver(wall);
				
				// Place Portal
				portal = new Portal(this, root);
				portal.placePortal(23, 23);
				this.man.addObserver(portal);
				
				// Place Gate
				ChipGate gate = new ChipGate(this, root);
				gate.placeGate(21, 23);
				this.man.addObserver(gate);
				gate.addObserver(wall);
				
				// Place Chips
				Chip chip1 = new Chip(this, root);
				chip1.placeChip(1, 1);
				this.man.addObserver(chip1);
				Chip chip2 = new Chip(this, root);
				chip2.placeChip(23, 0);
				this.man.addObserver(chip2);
				Chip chip3 = new Chip(this, root);
				chip3.placeChip(1, 9);
				this.man.addObserver(chip3);
				Chip chip4 = new Chip(this, root);
				chip4.placeChip(1, 24);
				this.man.addObserver(chip4);
	}

	@Override
	public Portal getPortal() {
		return portal;
	}
	
	
}
