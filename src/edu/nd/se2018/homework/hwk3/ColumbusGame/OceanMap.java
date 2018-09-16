package edu.nd.se2018.homework.hwk3.ColumbusGame;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.Random;

public class OceanMap {
	boolean[][] oceanGrid = new boolean[25][25];
	final int dimensions = 25;
	Random rand = new Random();
	
	public void drawMap(ObservableList<Node> root, int scale) {
		for (int x=0; x<dimensions; x++) {
			for (int y=0; y<dimensions; y++) {
				Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.PALETURQUOISE);
				root.add(rect);
				oceanGrid[x][y] = false;
			}
		}
		
		int cnt = 0;		
		while (cnt < 10) { // fill 10 blocks with green
			int n1 = rand.nextInt(24);
			int n2 = rand.nextInt(24);
			
			if (!oceanGrid[n1][n2]) {
				Rectangle rect = new Rectangle(n1*scale, n2*scale, scale, scale);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.GREEN);
				root.add(rect);
				oceanGrid[n1][n2] = true;
				cnt++;
			}
		}
	}
	
	public boolean getMap(int x, int y) {
		return oceanGrid[x][y];
	}
}