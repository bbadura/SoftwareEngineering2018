package edu.nd.se2018.homework.hwk3.ColumbusGame;

import java.awt.Point;
import java.util.Observable;

public class Ship extends Observable{
	Point currentLocation;
	OceanMap oceanMap;
	
	int scale;
	
	public Ship(OceanMap map) {
		currentLocation = new Point(24,12);
		oceanMap = map;
	}
	
	public Point getShipLocation() {
		return currentLocation;
	}

	public void goEast() {
		if (currentLocation.x < 24) {
			boolean island = oceanMap.getMap(currentLocation.x+1,currentLocation.y);
			if (!island) {
				currentLocation.x++;
				setChanged();
				notifyObservers();
			}
		}
	}

	public void goWest() {
		if (currentLocation.x > 0) {
			boolean island = oceanMap.getMap(currentLocation.x-1,currentLocation.y);
			if (!island) {
				currentLocation.x--;
				setChanged();
				notifyObservers();
			}
		}
	}

	public void goSouth() {
		if (currentLocation.y < 24) {
			boolean island = oceanMap.getMap(currentLocation.x,currentLocation.y+1);
			if (!island) {
				currentLocation.y++;
				setChanged();
				notifyObservers();
			}
		}
		
	}

	public void goNorth() {
		if (currentLocation.y > 0) {
			boolean island = oceanMap.getMap(currentLocation.x,currentLocation.y-1);
			if (!island) {
				currentLocation.y--;
				setChanged();
				notifyObservers();
			}
		}
		
	}
	
}
