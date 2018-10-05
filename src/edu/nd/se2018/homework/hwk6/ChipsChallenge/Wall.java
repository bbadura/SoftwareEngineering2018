package edu.nd.se2018.homework.hwk6.ChipsChallenge;

import java.util.Observable;
import java.util.Observer;

import edu.nd.se2018.homework.hwk6.ChipsChallenge.Level.ChipsBoard;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Wall implements Observer{
	ChipsBoard board;
	Image wallImage;
	ObservableList<Node> root;
	ImageView[][] wallView = new ImageView[25][25];
	
	int scale = 25;
	
	public Wall(ChipsBoard board, ObservableList<Node> root) {
		this.board = board;
		this.root = root;
		wallImage = new Image(getClass().getResource("Level/textures/wall.png").toExternalForm(),25,25,true,true);
	}
	
	public void buildStraightWall(int startX, int startY, int endX, int endY) {
		if (startX == endX || startY == endY) {
			for (int i=startX; i<=endX; i++) {
				for (int j=startY; j<=endY; j++) {
					wallView[i][j] = new ImageView();
					wallView[i][j].setImage(wallImage);
					wallView[i][j].setX(i * scale);
					wallView[i][j].setY(j * scale);
					this.root.add(wallView[i][j]);
					board.setMap(i, j, true);
				}
			}
		}
		else {
			System.out.println("Not a straight line. Wall not drawn.");
		}
	}
	
	public void buildSquareWall(int centerX, int centerY, int radius) {
		if ((centerX+radius < 25 && centerX-radius >= 0) && (centerY+radius < 25 && centerY-radius >= 0)) {
			int j = centerY-radius;
			for (int i=centerX-radius; i<=centerX+radius; i++) {
				wallView[i][j] = new ImageView();
				wallView[i][j].setImage(wallImage);
				wallView[i][j].setX(i * scale);
				wallView[i][j].setY(j * scale);
				this.root.add(wallView[i][j]);
				board.setMap(i, j, true);
			}
			
			j = centerY+radius;
			for (int i=centerX-radius; i<=centerX+radius; i++) {
				wallView[i][j] = new ImageView();
				wallView[i][j].setImage(wallImage);
				wallView[i][j].setX(i * scale);
				wallView[i][j].setY(j * scale);
				this.root.add(wallView[i][j]);
				board.setMap(i, j, true);
			}
			
			int i = centerX+radius;
			for (j=centerY-radius; j<=centerY+radius; j++) {
				wallView[i][j] = new ImageView();
				wallView[i][j].setImage(wallImage);
				wallView[i][j].setX(i * scale);
				wallView[i][j].setY(j * scale);
				this.root.add(wallView[i][j]);
				board.setMap(i, j, true);
			}
			
			i = centerX-radius;
			for (j=centerY-radius; j<=centerY+radius; j++) {
				wallView[i][j] = new ImageView();
				wallView[i][j].setImage(wallImage);
				wallView[i][j].setX(i * scale);
				wallView[i][j].setY(j * scale);
				this.root.add(wallView[i][j]);
				board.setMap(i, j, true);
			}
			
		}
		else {
			System.out.println("Not within bounds. Wall not drawn.");
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Door){
			boolean unlocked = ((Door)o).isUnlocked();
			if (unlocked) {
				this.root.remove(wallView[((Door)o).getDoorLocation().x][((Door)o).getDoorLocation().y]);
			}
		}
		if (o instanceof ChipGate){
			boolean unlocked = ((ChipGate)o).isUnlocked();
			if (unlocked) {
				this.root.remove(wallView[((ChipGate)o).getGateLocation().x][((ChipGate)o).getGateLocation().y]);
			}
		}
	}
}
