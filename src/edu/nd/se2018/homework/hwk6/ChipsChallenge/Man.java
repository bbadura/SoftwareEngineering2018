package edu.nd.se2018.homework.hwk6.ChipsChallenge;

import edu.nd.se2018.homework.hwk6.ChipsChallenge.Level.ChipsBoard;
import java.awt.Point;
import java.util.Observable;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Man extends Observable{
	Point currentLocation;
	ChipsBoard board;
	ImageView ManView = new ImageView();
	ObservableList<Node> root;
	
	int scale = 25;
	
	public Man(ChipsBoard board, ObservableList<Node> root) {
		currentLocation = new Point(12,12);
		this.board = board;
		this.root = root;
		Image normalTileImage = new Image(getClass().getResource("Level/textures/chipDown.png").toExternalForm(),25,25,true,true);
		ManView.setImage(normalTileImage);
		ManView.setX(currentLocation.x * scale);
		ManView.setY(currentLocation.y * scale);
		root.add(ManView);
		this.board.addMan(this);
	}
	
	public Point getManLocation() {
		return currentLocation;
	}

	public void goEast() {
		if (currentLocation.x < 24) {
			boolean blocked = board.getMap(currentLocation.x+1,currentLocation.y);
			if (!blocked) {
				Image ManRight = new Image(getClass().getResource("Level/textures/chipRight.png").toExternalForm(),25,25,true,true);
				ManView.setImage(ManRight);
				currentLocation.x++;
				ManView.setX(currentLocation.x * scale);
				ManView.setY(currentLocation.y * scale);
				setChanged();
				notifyObservers();
			}
		}
	}

	public void goWest() {
		if (currentLocation.x > 0) {
			boolean blocked = board.getMap(currentLocation.x-1,currentLocation.y);
			if (!blocked) {
				Image normalTileImage = new Image(getClass().getResource("Level/textures/chipLeft.png").toExternalForm(),25,25,true,true);
				ManView.setImage(normalTileImage);
				currentLocation.x--;
				ManView.setX(currentLocation.x * scale);
				ManView.setY(currentLocation.y * scale);
				setChanged();
				notifyObservers();
			}
		}
	}

	public void goSouth() {
		if (currentLocation.y < 24) {
			boolean blocked = board.getMap(currentLocation.x,currentLocation.y+1);
			if (!blocked) {
				Image normalTileImage = new Image(getClass().getResource("Level/textures/chipDown.png").toExternalForm(),25,25,true,true);
				ManView.setImage(normalTileImage);
				currentLocation.y++;
				ManView.setX(currentLocation.x * scale);
				ManView.setY(currentLocation.y * scale);
				setChanged();
				notifyObservers();
			}
		}
	}

	public void goNorth() {
		if (currentLocation.y > 0) {
			boolean blocked = board.getMap(currentLocation.x,currentLocation.y-1);
			if (!blocked) {
				Image normalTileImage = new Image(getClass().getResource("Level/textures/chipUp.png").toExternalForm(),25,25,true,true);
				ManView.setImage(normalTileImage);
				currentLocation.y--;
				ManView.setX(currentLocation.x * scale);
				ManView.setY(currentLocation.y * scale);
				setChanged();
				notifyObservers();
			}
		}
	}
}
