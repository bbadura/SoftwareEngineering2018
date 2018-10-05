package edu.nd.se2018.homework.hwk6.ChipsChallenge;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import edu.nd.se2018.homework.hwk6.ChipsChallenge.Level.ChipsBoard;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Key extends Observable implements Observer {
	Point keyLocation = new Point(0,0);;
	ChipsBoard board;
	Image keyImage;
	ObservableList<Node> root;
	ImageView keyView = new ImageView();
	boolean acquired;
	Point manLocation;
	
	int scale = 25;
	
	public Key(ChipsBoard board, ObservableList<Node> root, String color) {
		this.board = board;
		this.root = root;
		acquired = false;
		String file = "";
		
        switch(color) 
        { 
            case "blue": 
                file = "Level/textures/blueKey.png";
                break; 
            case "green": 
            	file = "Level/textures/greenKey.png"; 
                break; 
            case "red": 
            	file = "Level/textures/redKey.png"; 
                break;
            case "yellow": 
            	file = "Level/textures/yellowKey.png";
                break;
            default: 
                System.out.println("not a valid color"); 
        } 
		
		keyImage = new Image(getClass().getResource(file).toExternalForm(),25,25,true,true);
	}
	
	public void placeKey(int x, int y) {
		keyLocation.x = x;
		keyLocation.y = y;
		keyView.setImage(keyImage);
		keyView.setX(keyLocation.x * scale);
		keyView.setY(keyLocation.y * scale);
		this.root.add(keyView);
	}
	
	private void collectKey() {
		this.root.remove(keyView);
		acquired = true;
		setChanged();
		notifyObservers();
	}
	
	public boolean isCollected() {
		return acquired;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Man){
			manLocation = ((Man)o).getManLocation();
			if (manLocation.x == keyLocation.x && manLocation.y == keyLocation.y) {
				collectKey();
			}
		}
	}
}
