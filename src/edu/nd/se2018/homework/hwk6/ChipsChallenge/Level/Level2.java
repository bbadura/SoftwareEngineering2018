package edu.nd.se2018.homework.hwk6.ChipsChallenge.Level;


import edu.nd.se2018.homework.hwk6.ChipsChallenge.Door;
import edu.nd.se2018.homework.hwk6.ChipsChallenge.Key;
import edu.nd.se2018.homework.hwk6.ChipsChallenge.Portal;
import edu.nd.se2018.homework.hwk6.ChipsChallenge.Wall;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class Level2 extends ChipsBoard{
	Portal portal;

	@Override
	public void buildElements(ObservableList<Node> root) {
		
		// Build Walls
		Wall wall = new Wall(this, root);
		wall.buildStraightWall(0, 9, 9, 9);
	}

	@Override
	public Portal getPortal() {
		return portal;
	}
	
	
}
