package edu.nd.se2018.homework.hwk6.ChipsChallenge.Level;

import java.util.Observable;
import java.util.Observer;

import edu.nd.se2018.homework.hwk6.ChipsChallenge.Portal;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class BoardController implements Observer{
	
	ChipsBoard board;
	public ObservableList<Node> root;
	Portal portal;
	
	public BoardController(ObservableList<Node> root) {
		this.root = root;
		board = new ChipsBoard();
	}
	
	public void run() {
		board.drawBoard(root);
		board.buildLevel1(root);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
