package edu.nd.se2018.homework.hwk6.ChipsChallenge;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import edu.nd.se2018.homework.hwk6.ChipsChallenge.Level.ChipsBoard;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Portal implements Observer{
	public static Portal instance = new Portal();
	Point portalLocation = new Point(0,0);;
	ChipsBoard board;
	Image portalImage;
	ObservableList<Node> root;
	ImageView portalView = new ImageView();
	Point manLocation;
	boolean reached = false;
	
	int scale = 25;
	
	private Portal() {
		
	}
	
	public Portal(ChipsBoard board, ObservableList<Node> root) {
		this.board = board;
		this.root = root; 
		
		portalImage = new Image(getClass().getResource("Level/textures/portal.png").toExternalForm(),25,25,true,true);
	}
	
	public void placePortal(int x, int y) {
		portalLocation.x = x;
		portalLocation.y = y;
		portalView.setImage(portalImage);
		portalView.setX(portalLocation.x * scale);
		portalView.setY(portalLocation.y * scale);
		this.root.add(portalView);
	}
	
	public void setReached() {
		reached = true;
		this.root.remove(portalView);
	}
	
	public Point getPortalLocation() {
		return portalLocation;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Man){
			manLocation = ((Man)o).getManLocation();
			
			if (manLocation.x == portalLocation.x && manLocation.y == portalLocation.y) {
				setReached();
				System.out.println("You've reached the portal");
			}
		}
		
	}
}
