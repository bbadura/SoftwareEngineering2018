package edu.nd.se2018.homework.hwk6.ChipsChallenge;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import edu.nd.se2018.homework.hwk6.ChipsChallenge.Level.ChipsBoard;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Door extends Observable implements Observer {
	Point doorLocation = new Point(0,0);;
	ChipsBoard board;
	Image doorImage;
	ObservableList<Node> root;
	ImageView doorView = new ImageView();
	boolean unlocked;
	Point manLocation;
	Key key;
	
	int scale = 25;
	
	public Door(ChipsBoard board, ObservableList<Node> root, String color, Key key) {
		this.board = board;
		this.root = root;
		this.key = key;
		unlocked = false;
		String file = "";
		
        switch(color) 
        { 
            case "blue": 
                file = "Level/textures/blueKeyWall.png";
                break; 
            case "green": 
            	file = "Level/textures/greenKeyWall.png"; 
                break; 
            case "red": 
            	file = "Level/textures/redKeyWall.png"; 
                break;
            case "yellow": 
            	file = "Level/textures/yellowKeyWall.png";
                break;
            default: 
                System.out.println("not a valid color"); 
        }
        
        this.key.addObserver(this);
		
		doorImage = new Image(getClass().getResource(file).toExternalForm(),25,25,true,true);
	}
	
	public void placeDoor(int x, int y) {
		doorLocation.x = x;
		doorLocation.y = y;
		doorView.setImage(doorImage);
		doorView.setX(doorLocation.x * scale);
		doorView.setY(doorLocation.y * scale);
		this.root.add(doorView);
		this.board.setMap(doorLocation.x, doorLocation.y, true);
	}
	
	private void removeDoor() {
		this.root.remove(doorView);
		setChanged();
		notifyObservers();
	}
	
	public boolean isUnlocked() {
		return unlocked;
	}
	
	public Point getDoorLocation() {
		return doorLocation;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Key){
			unlocked = ((Key)o).isCollected();
			this.board.setMap(doorLocation.x, doorLocation.y, false);
		}
		
		if (o instanceof Man) {
			manLocation = ((Man)o).getManLocation();
			if (manLocation.x == doorLocation.x && manLocation.y == doorLocation.y) {
				if (unlocked) {
					removeDoor();
				}
			}
		}
	}
}
