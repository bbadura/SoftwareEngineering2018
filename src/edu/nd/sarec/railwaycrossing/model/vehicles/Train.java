package edu.nd.sarec.railwaycrossing.model.vehicles;

import java.util.Observable;

import edu.nd.sarec.railwaycrossing.model.infrastructure.Direction;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Represents the train entity object
 * @author jane
 *
 */
public class Train extends Observable implements IVehicle{
	private double currentX = 0;
	private double currentY = 0;
	private double originalX = 0;
	private Image img;
	private ImageView imgView;
	private int trainLength = 35;
	private Direction direction;
	
	public Train(int x, int y, Direction direction, String img_src){
		this.currentX = x;
		this.currentY = y;
		this.direction = direction;
		originalX = x;
		img = new Image(img_src,120,trainLength,false,false);
		imgView = new ImageView(img);
		imgView.setX(currentX);
		imgView.setY(currentY);
	}
	
	public double getVehicleX(){
		return currentX;
	}
	
	public double getVehicleY(){
		return currentY;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public void move(){
		if (direction == Direction.WEST)
			currentX-=2;
		else if (direction == Direction.EAST)
			currentX+=2;
		imgView.setX(currentX);
		setChanged();
		notifyObservers();
	}
	
	public boolean offScreen(){
		if (direction == Direction.WEST) {
			if (currentX < -200)
				return true;
			else
				return false;
		}
		else if (direction == Direction.EAST) {
			if (currentX > 1450)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	public void reset(){
		currentX = originalX;
	}

	//@Override
	public Node getImageView() {
		return imgView;
	}
}