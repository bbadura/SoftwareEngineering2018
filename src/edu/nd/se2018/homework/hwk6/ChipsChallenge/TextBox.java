package edu.nd.se2018.homework.hwk6.ChipsChallenge;

import edu.nd.se2018.homework.hwk6.ChipsChallenge.Level.ChipsBoard;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.text.Text;

public class TextBox {
	ChipsBoard board;
	ObservableList<Node> root;
	int scale = 25;
	
	Text blueKey;
	Text redKey;
	Text yellowKey;
	Text greenKey;
	Text chips;
	
	String bka = "no";
	String rka = "no";
	String yka = "no";
	String gka = "no";
	int chipCnt = 0;
	
	public TextBox(ChipsBoard board, ObservableList<Node> root) {
		this.board = board;
		this.root = root;
	}
	
	public void writeText() {
		updateValues();
		clearText();
		
		//Blue Key
		blueKey = new Text();
		blueKey.setText("Blue Key Acquired? " + bka);
		blueKey.setX(25.3*scale);
		blueKey.setY(2*scale);
		root.add(blueKey);
		
		//Red Key
		redKey = new Text();
		redKey.setText("Red Key Acquired? " + rka);
		redKey.setX(25.3*scale);
		redKey.setY(3*scale);
		root.add(redKey);
		
		//Yellow Key
		yellowKey = new Text();
		yellowKey.setText("Yellow Key Acquired? " + yka);
		yellowKey.setX(25.3*scale);
		yellowKey.setY(4*scale);
		root.add(yellowKey);
		
		//Green Key
		greenKey = new Text();
		greenKey.setText("Green Key Acquired? " + gka);
		greenKey.setX(25.3*scale);
		greenKey.setY(5*scale);
		root.add(greenKey);
		
		//Green Key
		chips = new Text();
		chips.setText("Chip Count: " + chipCnt);
		chips.setX(25.3*scale);
		chips.setY(6*scale);
		root.add(chips);
		
	}
	
	private void clearText() {
		root.remove(blueKey);
		root.remove(redKey);
		root.remove(yellowKey);
		root.remove(greenKey);
		root.remove(chips);
	}
	
	private void updateValues() {
		bka = board.getKeyStatus("blue");
		rka = board.getKeyStatus("red");
		yka = board.getKeyStatus("yellow");
		gka = board.getKeyStatus("green");
		chipCnt = board.getChipCnt();
	}
}
