package edu.nd.sarec.railwaycrossing.model.vehicles;

import java.util.Observable;
import java.util.Observer;

import edu.nd.sarec.railwaycrossing.model.infrastructure.TJunction;
import edu.nd.sarec.railwaycrossing.model.infrastructure.gate.CrossingGate;
import edu.nd.sarec.railwaycrossing.view.CarImageSelector;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

/**
 * Represents Car object
 * @author jane
 *
 */
public class Car extends Observable implements IVehicle, Observer{
	private ImageView ivCar;
	private double currentX = 0;
	private double currentY = 0;
	private double originalY = 0;
	private boolean gateDown = false;
	double leadCarY = -1;  // Current Y position of car directly infront of this one
	private double leadCarX = -1;
	private Car inFront = null;
	private Car behind = null;
	private double speed = 0.5;
	private int turnRand = (int)(Math.random() * 10);
	private boolean eastWest = false;
	private TJunction junctions;
	private boolean transfered = false;
		
	/**
	 * Constructor
	 * @param x initial x coordinate of car
	 * @param y initial y coordinate of car
	 */
	public Car(int x, int y, TJunction junctions){
		this.currentX = x;
		this.currentY = y;
		this.junctions = junctions;
		originalY = y;
		ivCar = new ImageView(CarImageSelector.getImage());
		ivCar.setX(getVehicleX());
		ivCar.setY(getVehicleY());
	}
		
	@Override
	public Node getImageView() {
		return ivCar;
	}
	
	public boolean gateIsClosed(){
		return gateDown;
	}
	
	public double getVehicleX(){
		return currentX;
	}
	public double getVehicleY(){
		return currentY;
	}
	
	public void move(){
		boolean canMove = true; 
		
		if (!eastWest) {
			// First case.  Car is at the front of the stopping line.
			if (gateDown && getVehicleY() < 430 && getVehicleY()> 390) {
				canMove = false;
			}
			
			// Second case. Car is too close too other car.
			if (leadCarY != -1  && getDistanceToLeadCar() < 50) {
				canMove = false;
			}
			
			if ((currentY > 685 && currentY < 715) && currentX == 391) {
				if (canMove && turnRand <= 2) {
					currentY = 691;
					currentX+=speed;
					ivCar.setX(currentX);
					eastWest = true;
					junctions.insertEastWest(this);
					this.deleteObserver(this.behind);
					this.inFront.deleteObserver(this);
					this.inFront.addObserver(this.behind);
				}

			}
			
			if (canMove){
				currentY+=speed;
				ivCar.setY(currentY);
			}
		}
		else if (eastWest) {
			if (currentX < 750 && leadCarX == -1) {
				currentX+=speed;
				ivCar.setX(currentX);
			}
			else if (currentX < 750 && getDistanceToLeadCar() > 50) {
				currentX+=speed;
				ivCar.setX(currentX);
			}

		}
		setChanged();
		notifyObservers();
	}
	
	public void setSpeed(double speed){
		this.speed = speed;
	}
	
	public void setGateDownFlag(boolean gateDown){
		this.gateDown = gateDown;
	}
	
	public boolean offScreen(){
		if (currentY > 1020)
			return true;
		else
			return false;			
	}
		
	public void reset(){
		currentY = originalY;
	}
	
	public double getDistanceToLeadCar(){
		if (!eastWest)
			return Math.abs(leadCarY-getVehicleY());
		else
			return Math.abs(leadCarX-getVehicleX());
	}
	
	public void removeLeadCar(){
		leadCarY = -1;
	}
	
	public void setInFront(Car newFront) {
		this.inFront = newFront;
	}
	
	public void setBehind(Car newBehind) {
		this.behind = newBehind;
	}

	@Override
	public void update(Observable o, Object arg1) {
		if (o instanceof Car){
			leadCarY = (((Car)o).getVehicleY());
			if (leadCarY > 1020)
				leadCarY = -1;
			if (eastWest) {
				leadCarX = (((Car)o).getVehicleX());
			}
		}
			
		if (o instanceof CrossingGate){
			CrossingGate gate = (CrossingGate)o;
			if(gate.getTrafficCommand()=="STOP")			
				gateDown = true;
			else
				gateDown = false;
					
		}
	}	
}
