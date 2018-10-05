package edu.nd.se2018.homework.hwk6.ChipsChallenge.Level;

import edu.nd.se2018.homework.hwk6.ChipsChallenge.Wall;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class Level1 extends ChipsBoard{

	@Override
	public void addWalls(ObservableList<Node> root) {
		Wall wall = new Wall(this, root);
		wall.buildStraightWall(0, 9, 9, 9);
	}

	@Override
	public void addKeys() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addDoors() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addChips() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPortal() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addObstacles() {
		// TODO Auto-generated method stub
		
	}

}
