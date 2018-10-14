package edu.nd.se2018.homework.hwk6.ChipsChallenge.Level;


import edu.nd.se2018.homework.hwk6.ChipsChallenge.Chip;
import edu.nd.se2018.homework.hwk6.ChipsChallenge.ChipGate;
import edu.nd.se2018.homework.hwk6.ChipsChallenge.Door;
import edu.nd.se2018.homework.hwk6.ChipsChallenge.Key;
import edu.nd.se2018.homework.hwk6.ChipsChallenge.Portal;
import edu.nd.se2018.homework.hwk6.ChipsChallenge.Wall;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class Level1 extends ChipsBoard {
	Portal portal;

	@Override
	public void buildElements(ObservableList<Node> root) {
		
		System.out.println("building level 1");
		
		// Build Walls
		Wall wall = new Wall(this, root);
		wall.buildStraightWall(0, 9, 9, 9);
		wall.buildStraightWall(15, 15, 24, 15);
		wall.buildSquareWall(12, 12, 3);
		wall.buildSquareWall(20, 4, 2);
		wall.buildSquareWall(4, 20, 2);
		wall.buildSquareWall(4, 4, 2);
		wall.buildSquareWall(20, 20, 2);
		wall.buildSquareWall(12, 2, 2);
		
		// Place Keys and Doors
		// Blue key/door pair
		Key blueKey = new Key(this, root, "blue");
		blueKey.placeKey(12, 14);
		this.man.addObserver(blueKey);
		Door blueDoor = new Door(this, root, "blue", blueKey);
		blueDoor.placeDoor(15, 12);
		this.man.addObserver(blueDoor);
		blueDoor.addObserver(wall);
		// Red key/door pair
		Key redKey = new Key(this, root, "red");
		redKey.placeKey(23, 14);
		this.man.addObserver(redKey);
		Door redDoor = new Door(this, root, "red", redKey);
		redDoor.placeDoor(18, 15);
		this.man.addObserver(redDoor);
		redDoor.addObserver(wall);
		// Green key/door pair
		Key greenKey = new Key(this, root, "green");
		greenKey.placeKey(4, 13);
		this.man.addObserver(greenKey);
		Door greenDoor = new Door(this, root, "green", greenKey);
		greenDoor.placeDoor(20, 6);
		this.man.addObserver(greenDoor);
		greenDoor.addObserver(wall);
		// Yellow key/door pair
		Key yellowKey = new Key(this, root, "yellow");
		yellowKey.placeKey(16, 1);
		this.man.addObserver(yellowKey);
		Door yellowDoor = new Door(this, root, "yellow", yellowKey);
		yellowDoor.placeDoor(5, 6);
		this.man.addObserver(yellowDoor);
		yellowDoor.addObserver(wall);
		
		// Place Portal
		portal = new Portal(this, root);
		portal.placePortal(12, 2);
		this.man.addObserver(portal);
		
		// Place Gate
		ChipGate gate = new ChipGate(this, root);
		gate.placeGate(12, 4);
		this.man.addObserver(gate);
		gate.addObserver(wall);
		
		// Place Chips
		Chip chip1 = new Chip(this, root);
		chip1.placeChip(20, 12);
		this.man.addObserver(chip1);
		Chip chip2 = new Chip(this, root);
		chip2.placeChip(8, 22);
		this.man.addObserver(chip2);
		Chip chip3 = new Chip(this, root);
		chip3.placeChip(4, 4);
		this.man.addObserver(chip3);
		Chip chip4 = new Chip(this, root);
		chip4.placeChip(20, 4);
		this.man.addObserver(chip4);
		
	}

	@Override
	public Portal getPortal() {
		return portal;
	}
	
	
}
