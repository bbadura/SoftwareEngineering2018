package edu.nd.se2018.homework.hwk6.ChipsChallenge;

import javafx.application.Application;
import edu.nd.se2018.homework.hwk6.ChipsChallenge.Level.ChipsBoard;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameRunner extends Application {

	final private int cellSize = 25;
	final private int mapSize = 25;
	int scale = 25;
	Scene scene;
   
	// Globals
    Pane root = new AnchorPane();;
    ChipsBoard board = new ChipsBoard();
    Man man;
    Portal portal;
    TextBox text;
    int level = 1;
    
	@Override
	public void start(Stage chipStage) throws Exception {
		
		scene = new Scene(root,mapSize*cellSize+cellSize*7,mapSize*cellSize);	
		chipStage.setTitle("Chips Challenge");
		chipStage.setScene(scene);
		
		board.drawBoard(root.getChildren());
		man = new Man(board,root.getChildren());
		board.buildLevel1(root.getChildren());
		portal = board.getPortal();
		text = new TextBox(board,root.getChildren());
		text.writeText();
		
		Text t = new Text();
		t.setText("Chips Challenge Level " + level);
		t.setX(25.3*scale);
		t.setY(1*scale);
		root.getChildren().add(t);
		
		chipStage.show();
		
		
		this.play(chipStage);
	}
	
	
	private void play(Stage chipStage) {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent ke) {
				switch(ke.getCode()) {
					case RIGHT:
						man.goEast();
						if (portalReached() && level==2) {
							board.drawBoard(root.getChildren());
							man = new Man(board,root.getChildren());
							board.buildLevel2(root.getChildren());
							portal = board.getPortal();
						}
						else if (portalReached() && level==4) {
							chipStage.close();
						}
						break;
					case LEFT:
						man.goWest();
						if (portalReached() && level==2) {
							board.drawBoard(root.getChildren());
							man = new Man(board,root.getChildren());
							board.buildLevel2(root.getChildren());
							portal = board.getPortal();
						}
						else if (portalReached() && level==4) {
							chipStage.close();
						}
						break;
					case UP:
						man.goNorth();
						if (portalReached() && level==2) {
							board.drawBoard(root.getChildren());
							man = new Man(board,root.getChildren());
							board.buildLevel2(root.getChildren());
							portal = board.getPortal();
						}
						else if (portalReached() && level==4) {
							chipStage.close();
						}
						break;
					case DOWN:
						man.goSouth();
						if (portalReached() && level==2) {
							board.drawBoard(root.getChildren());
							man = new Man(board,root.getChildren());
							board.buildLevel2(root.getChildren());
							portal = board.getPortal();
						}
						else if (portalReached() && level==4) {
							chipStage.close();
						}
						break;
					case ESCAPE:
						chipStage.close();
						break;
					default:
						break;
				}
				text.writeText();
			}
		});
	}
	
	private boolean portalReached() {
		if ((man.getManLocation().x == portal.getPortalLocation().x) && (man.getManLocation().y == portal.getPortalLocation().y) ) {
			level++;
			return true;
		}
		else {
			return false;
		}
	}


	public static void main(String args[]) {
		launch(args);
	}
}