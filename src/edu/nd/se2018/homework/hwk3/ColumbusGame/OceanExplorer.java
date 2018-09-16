package edu.nd.se2018.homework.hwk3.ColumbusGame;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class OceanExplorer extends Application {

	final private int cellSize = 25;  
	final private int mapSize = 25;
	int scale = 25;
	Scene scene;
	ImageView shipImageView = new ImageView();
	ImageView pirateShipImageView1 = new ImageView();
	ImageView pirateShipImageView2 = new ImageView();
   
	// Globals
    Pane root;
    OceanMap oceanMap = new OceanMap();
    Ship ship;
    PirateShip pirateShip1;
    PirateShip pirateShip2;
    
	@Override
	public void start(Stage oceanStage) throws Exception {
		root = new AnchorPane();
		
		scene = new Scene(root,mapSize*cellSize,mapSize*cellSize);	
		oceanStage.setTitle("1492 Columbus Sailed the Ocean Blue");
		oceanStage.setScene(scene);
		
		oceanMap.drawMap(root.getChildren(), scale);
		
		// Ship info
		ship = new Ship(oceanMap);
		pirateShip1 = new PirateShip(oceanMap);
		pirateShip2 = new PirateShip(oceanMap);
		
		// Add as observers
		ship.addObserver(pirateShip1);
		ship.addObserver(pirateShip2);
		
		Image shipImage = new Image(getClass().getResource("ColumbusShip.png").toExternalForm(),25,25,true,true);
		shipImageView.setImage(shipImage);
        shipImageView.setX(ship.getShipLocation().x * scale);
        shipImageView.setY(ship.getShipLocation().y * scale);
        
        Image pirateShipImage1 = new Image(getClass().getResource("pirateship.gif").toExternalForm(),25,25,true,true);
        pirateShipImageView1.setImage(pirateShipImage1);
        pirateShipImageView1.setX(pirateShip1.getPirateShipLocation().x * scale);
        pirateShipImageView1.setY(pirateShip1.getPirateShipLocation().y * scale);
        
        Image pirateShipImage2 = new Image(getClass().getResource("pirateship.gif").toExternalForm(),25,25,true,true);
        pirateShipImageView2.setImage(pirateShipImage2);
        pirateShipImageView2.setX(pirateShip2.getPirateShipLocation().x * scale);
        pirateShipImageView2.setY(pirateShip2.getPirateShipLocation().y * scale);
        
        root.getChildren().add(shipImageView);
        root.getChildren().add(pirateShipImageView1);
        root.getChildren().add(pirateShipImageView2);
		
		oceanStage.show();
		
		this.startSailing();
	}
	
	
	private void startSailing() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent ke) { 
				switch(ke.getCode()) {
					case RIGHT:
						ship.goEast();
						break;
					case LEFT:
						ship.goWest();
						break;
					case UP:
						ship.goNorth();
						break;
					case DOWN:
						ship.goSouth();
						break;
					default:
						break;
				} 
				
				// Refresh views
				shipImageView.setX(ship.getShipLocation().x*scale);
				shipImageView.setY(ship.getShipLocation().y*scale);
				pirateShipImageView1.setX(pirateShip1.getPirateShipLocation().x*scale);
				pirateShipImageView1.setY(pirateShip1.getPirateShipLocation().y*scale);
				pirateShipImageView2.setX(pirateShip2.getPirateShipLocation().x*scale);
				pirateShipImageView2.setY(pirateShip2.getPirateShipLocation().y*scale);
			}
		});
	}


	public static void main(String args[]) {
		launch(args);
	}
}