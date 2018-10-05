package edu.nd.se2018.homework.hwk6.ChipsChallenge.Level;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Random;

abstract public class ChipsBoard {
	int scale = 25;
	public ObservableList<Node> root;
	boolean[][] boardGrid = new boolean[25][25];
	final int dimensions = 25;
	Random rand = new Random();
	
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
		
	}
	
	public boolean getMap(int x, int y) {
		return boardGrid[x][y];
	}
	
	public void setMap(int x, int y, boolean val) {
		boardGrid[x][y] = val;
	}
	
	public abstract void addWalls(ObservableList<Node> root);
	
	public abstract void addKeys();
	
	public abstract void addDoors();
	
	public abstract void addChips();
	
	public abstract void addPortal();
	
	public abstract void addObstacles();
}