package edu.nd.se2018.homework.hwk6.ChipsChallenge;

import edu.nd.se2018.homework.hwk6.ChipsChallenge.Level.ChipsBoard;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Wall {
	ChipsBoard board;
	Image wallImage;
	ObservableList<Node> root;
	
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
					ImageView wallView = new ImageView();
					wallView.setImage(wallImage);
					wallView.setX(i * scale);
					wallView.setY(j * scale);
					this.root.add(wallView);
					board.setMap(i, j, true);
				}
			}
		}
		else {
			System.out.println("Not a straight line. Wall not drawn.");
		}
	}
}
