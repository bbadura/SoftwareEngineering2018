package edu.nd.se2018.homework.hwk6.ChipsChallenge;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import edu.nd.se2018.homework.hwk6.ChipsChallenge.Level.ChipsBoard;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Chip extends Observable implements Observer{
	Point chipLocation = new Point(0,0);;
	ChipsBoard board;
	Image chipImage;
	ObservableList<Node> root;
	ImageView chipView = new ImageView();
	boolean acquired;
	Point manLocation;
	
	int scale = 25;
	
	public Chip(ChipsBoard board, ObservableList<Node> root) {
		this.board = board;
		this.root = root;
		acquired = false;
		
		chipImage = new Image(getClass().getResource("Level/textures/chipItem.png").toExternalForm(),25,25,true,true);
	}
	
	public void placeChip(int x, int y) {
		chipLocation.x = x;
		chipLocation.y = y;
		chipView.setImage(chipImage);
		chipView.setX(chipLocation.x * scale);
		chipView.setY(chipLocation.y * scale);
		this.root.add(chipView);
	}
	
	private void collectChip() {
		this.root.remove(chipView);
		acquired = true;
		board.chipCnt++;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Man){
			manLocation = ((Man)o).getManLocation();
			if (manLocation.x == chipLocation.x && manLocation.y == chipLocation.y) {
				collectChip();
			}
		}
	}
}
