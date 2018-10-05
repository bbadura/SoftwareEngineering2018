package edu.nd.se2018.homework.hwk6.ChipsChallenge;

import javafx.application.Application;
import edu.nd.se2018.homework.hwk6.ChipsChallenge.Level.ChipsBoard;
import edu.nd.se2018.homework.hwk6.ChipsChallenge.Level.Level1;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameRunner extends Application {

	final private int cellSize = 25;  
	final private int mapSize = 25;
	int scale = 25;
	Scene scene;
   
	// Globals
    Pane root;
    ChipsBoard board = new Level1();
    Man man;
    
	@Override
	public void start(Stage chipStage) throws Exception {
		root = new AnchorPane();
		
		scene = new Scene(root,mapSize*cellSize,mapSize*cellSize);	
		chipStage.setTitle("Chips Challenge");
		chipStage.setScene(scene);
		
		board.drawBoard(root.getChildren());
		board.addWalls(root.getChildren());
		
		man = new Man(board,root.getChildren());
		
		chipStage.show();
		
		
		this.play();
	}
	
	
	private void play() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent ke) { 
				switch(ke.getCode()) {
					case RIGHT:
						man.goEast();
						break;
					case LEFT:
						man.goWest();
						break;
					case UP:
						man.goNorth();
						break;
					case DOWN:
						man.goSouth();
						break;
					default:
						break;
				} 
				
			}
		});
	}


	public static void main(String args[]) {
		launch(args);
	}
}