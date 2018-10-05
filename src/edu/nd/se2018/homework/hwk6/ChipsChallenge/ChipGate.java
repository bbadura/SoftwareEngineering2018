package edu.nd.se2018.homework.hwk6.ChipsChallenge;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import edu.nd.se2018.homework.hwk6.ChipsChallenge.Level.ChipsBoard;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChipGate extends Observable implements Observer {
	Point gateLocation = new Point(0,0);;
	ChipsBoard board;
	Image gateImage;
	ObservableList<Node> root;
	ImageView gateView = new ImageView();
	boolean unlocked;
	Point manLocation;
	
	int scale = 25;
	
	public ChipGate(ChipsBoard board, ObservableList<Node> root) {
		this.board = board;
		this.root = root;
		unlocked = false;
        		
		gateImage = new Image(getClass().getResource("Level/textures/chipGate.png").toExternalForm(),25,25,true,true);
	}
	
	public void placeGate(int x, int y) {
		gateLocation.x = x;
		gateLocation.y = y;
		gateView.setImage(gateImage);
		gateView.setX(gateLocation.x * scale);
		gateView.setY(gateLocation.y * scale);
		this.root.add(gateView);
		this.board.setMap(gateLocation.x, gateLocation.y, true);
	}
	
	private void removeGate() {
		this.root.remove(gateView);
		setChanged();
		notifyObservers();
	}
	
	public boolean isUnlocked() {
		return unlocked;
	}
	
	public Point getGateLocation() {
		return gateLocation;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Key){
			unlocked = ((Key)o).isCollected();
			this.board.setMap(gateLocation.x, gateLocation.y, false);
		}
		
		if (o instanceof Man) {
			manLocation = ((Man)o).getManLocation();
			if (board.chipCnt == 4) {
				board.setMap(gateLocation.x, gateLocation.y, false);
				unlocked = true;
			}
			if (manLocation.x == gateLocation.x && manLocation.y == gateLocation.y) {
				if (unlocked) {
					removeGate();
				}
			}
		}
	}
}
