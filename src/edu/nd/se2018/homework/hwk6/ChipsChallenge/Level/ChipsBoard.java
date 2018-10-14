package edu.nd.se2018.homework.hwk6.ChipsChallenge.Level;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

import edu.nd.se2018.homework.hwk6.ChipsChallenge.Chip;
import edu.nd.se2018.homework.hwk6.ChipsChallenge.ChipGate;
import edu.nd.se2018.homework.hwk6.ChipsChallenge.Door;
import edu.nd.se2018.homework.hwk6.ChipsChallenge.Key;
import edu.nd.se2018.homework.hwk6.ChipsChallenge.Man;
import edu.nd.se2018.homework.hwk6.ChipsChallenge.Portal;
import edu.nd.se2018.homework.hwk6.ChipsChallenge.Wall;

public class ChipsBoard {
	int scale = 25;
	public ObservableList<Node> root;
	boolean[][] boardGrid = new boolean[25][25];
	final int dimensions = 25;
	Random rand = new Random();
	Man man;
	public int chipCnt;
	Portal portal;
	Wall wall;
	Key blueKey;
	Key redKey;
	Key greenKey;
	Key yellowKey;
	Door blueDoor;
	Door redDoor;
	Door yellowDoor;
	Door greenDoor;
	
	
	public void drawBoard(ObservableList<Node> root) {
		this.root = root;
		for (int x=0; x<dimensions; x++) {
			for (int y=0; y<dimensions; y++) {
				ImageView normalTile = new ImageView();
				Image normalTileImage = new Image(getClass().getResource("textures/BlankTile.png").toExternalForm(),25,25,true,true);
				normalTile.setImage(normalTileImage);
				normalTile.setX(x * scale);
				normalTile.setY(y * scale);
				this.root.add(normalTile);
				boardGrid[x][y] = false;
			}
		}
		chipCnt=0;
	}
	
	public boolean getMap(int x, int y) {
		return boardGrid[x][y];
	}
	
	public void setMap(int x, int y, boolean val) {
		boardGrid[x][y] = val;
	}
	
	public void addMan(Man man) {
		this.man = man;
	}
	
	public void buildLevel1(ObservableList<Node> root) {
		System.out.println("building level 1");
		
		// Build Walls
		wall = new Wall(this, root);
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
		blueKey = new Key(this, root, "blue");
		blueKey.placeKey(12, 14);
		this.man.addObserver(blueKey);
		blueDoor = new Door(this, root, "blue", blueKey);
		blueDoor.placeDoor(15, 12);
		this.man.addObserver(blueDoor);
		blueDoor.addObserver(wall);
		// Red key/door pair
		redKey = new Key(this, root, "red");
		redKey.placeKey(23, 14);
		this.man.addObserver(redKey);
		redDoor = new Door(this, root, "red", redKey);
		redDoor.placeDoor(18, 15);
		this.man.addObserver(redDoor);
		redDoor.addObserver(wall);
		// Green key/door pair
		greenKey = new Key(this, root, "green");
		greenKey.placeKey(4, 13);
		this.man.addObserver(greenKey);
		greenDoor = new Door(this, root, "green", greenKey);
		greenDoor.placeDoor(20, 6);
		this.man.addObserver(greenDoor);
		greenDoor.addObserver(wall);
		// Yellow key/door pair
		yellowKey = new Key(this, root, "yellow");
		yellowKey.placeKey(16, 1);
		this.man.addObserver(yellowKey);
		yellowDoor = new Door(this, root, "yellow", yellowKey);
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
	
	public void buildLevel2(ObservableList<Node> root) {
		System.out.println("building level 2");
		
		// Build Walls
		wall = new Wall(this, root);
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
		blueKey = new Key(this, root, "blue");
		blueKey.placeKey(7, 10);
		this.man.addObserver(blueKey);
		blueDoor = new Door(this, root, "blue", blueKey);
		blueDoor.placeDoor(3, 1);
		this.man.addObserver(blueDoor);
		blueDoor.addObserver(wall);
		// Red key/door pair
		redKey = new Key(this, root, "red");
		redKey.placeKey(24, 9);
		this.man.addObserver(redKey);
		redDoor = new Door(this, root, "red", redKey);
		redDoor.placeDoor(3, 24);
		this.man.addObserver(redDoor);
		redDoor.addObserver(wall);
		// Yellow key/door pair
		yellowKey = new Key(this, root, "yellow");
		yellowKey.placeKey(0, 20);
		this.man.addObserver(yellowKey);
		yellowDoor = new Door(this, root, "yellow", yellowKey);
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
	
	public Portal getPortal() {
		return portal;
	}
	
	public String getKeyStatus(String color) {
		String outString = "";
		switch(color) 
        { 
            case "blue": 
            	if (blueDoor.isUnlocked())
            		outString = "yes";
            	else
            		outString = "no";
                break; 
            case "green":
            	if (greenDoor.isUnlocked())
            		outString = "yes";
            	else
            		outString = "no";
                break; 
            case "red":
            	if (redDoor.isUnlocked())
            		outString = "yes";
            	else
            		outString = "no";
                break;
            case "yellow":
            	if (yellowDoor.isUnlocked())
            		outString = "yes";
            	else
            		outString = "no";
                break;
            default: 
                System.out.println("not a valid color"); 
        } 
		
		return outString;
	}
	
	public int getChipCnt() {
		return chipCnt;
	}
	
//	public abstract Portal getPortal();
//	
//	public abstract void buildElements(ObservableList<Node> root);
}