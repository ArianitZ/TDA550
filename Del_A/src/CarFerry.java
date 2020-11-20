import java.awt.*;
import java.util.Stack;

/**
 * A class that represents a car ferry. It is a sea based vehicle.
 * Uses a vehicle to represent its driving behaviour as well as internal structre.
 * A Ramp object is used to represent its ramp and a Loader object is used to
 * represent its loading capabilities.
 *
 * @param <C> only objects of type Vehicle can be loaded
 */
public class CarFerry<C extends Vehicle> implements SeaBasedVehicle{

    /**
     * A Loader object used for loading/unloading cargo
     */
    private Loader<C> loader;

    /**
     * A Stack of Vehicle objects used to represent the cargo of the ferry
     */
    private Stack<C> cargo;

    /**
     * The maximum number of vehicles on the cargo
     */
    private int maxCapacity;

    /**
     * A Vehicle object used to represent the driving behaviour of the ferry
     */
    private Vehicle seaBasedVehicle;

    /**
     * A Ramp object used for representing the ferry's ramp
     */
    private Ramp ramp;

    /**
     * Proximity threshold used for loading
     */
    private double proximityThreshold;

    /**
     * Maximum weight of a Vehicle that can be loaded
     */
    private double cargoWeightLimit;


    /**
     * Default constructor
     */
    public CarFerry(){
        seaBasedVehicle = new Vehicle(2,1000, 0.0, Color.white, "Båten", 90,
                                      0.0, 0.0, 20000);
        cargo = new Stack<>();
        maxCapacity = 30;
        loader = new Loader<>(cargo, maxCapacity);
        ramp = new Ramp(90, 0);
        proximityThreshold = 0.1;
        cargoWeightLimit = 3000;
    }

    public int getNrDoors(){
        return seaBasedVehicle.getNrDoors();
    }
    public double getEnginePower(){
        return seaBasedVehicle.getEnginePower();
    }
    public double getCurrentSpeed(){
        return seaBasedVehicle.getCurrentSpeed();
    }
    public Color getColor(){
        return seaBasedVehicle.getColor();
    }
    public void setColor(Color clr){ seaBasedVehicle.setColor(clr); }
    public double getWeight(){ return seaBasedVehicle.getWeight();}
    public double speedFactor(){return seaBasedVehicle.speedFactor();}
    public void stopEngine(){
        seaBasedVehicle.stopEngine();
    }
    public void gas(double amount){ seaBasedVehicle.gas(amount); }
    public void brake(double amount){ seaBasedVehicle.brake(amount);}
    public int getDirection(){return seaBasedVehicle.getDirection();}
    public double getxPosition(){return seaBasedVehicle.getxPosition();}
    public double getyPosition(){return seaBasedVehicle.getyPosition();}


    /**
     * Starts the engine unless the ramp is open.
     */
    public void startEngine() {
        if (ramp.getRampAngle() > ramp.getMinAngleRamp()) {
            System.out.println("You can't start the engine while having the ramp open");
        }
        else{
            seaBasedVehicle.startEngine();
        }
    }


    /**
     * Opens the ramp of the ferry
     */
    public void openRamp(){
        ramp.increaseRampAngle(ramp.getMaxAngleRamp(), seaBasedVehicle.getCurrentSpeed());
    }


    /**
     * Closes the ramp of the ferry
     */
    public void closeRamp(){
        ramp.decreaseRampAngle(ramp.getMaxAngleRamp());
    }


    /**
     * Checks whether or not the ramp is open.
     * @return true if ramp is open
     */
    public boolean isRampOpen(){
        return ramp.getRampAngle() == ramp.getMaxAngleRamp();
    }


    /**
     * returns the number of vehicles loaded on the ferry
     * @return current number of vehicles lodaed
     */
    public int getCurrentLoadQuantity(){
        return cargo.size();
    }


    /**
     * returns the maximum number of vehicles that can be loaded
     * @return the maximum number of vehicles that can be loaded
     */
    public int getMaxCapacity(){
        return maxCapacity;
    }


    /**
     * Turns the ferry to the left and its cargo
     */
    public void turnLeft(){
        seaBasedVehicle.turnLeft();
        synchronizeCargo();
    }


    /**
     * Turns the ferry to the right and its cargo
     */
    public void turnRight(){
        seaBasedVehicle.turnRight();
        synchronizeCargo();
    }


    /**
     * Moves the ferry/vehicle as well as its cargo
     */
    public void move(){
        seaBasedVehicle.move();
        synchronizeCargo();
    }


    private void synchronizeCargo(){
        loader.synchronizeCargo(seaBasedVehicle);
    }


    /**
     * returns the distance between the vehicle one wants to load onto the ferry and the ferry itself
     * @param vehicle the vehicle one wants to load onto the ferry
     * @return the distance between the vehicle one wants to load onto the ferry and the ferry itself
     */
    private double getDistance(C vehicle){
        double xDiff = this.seaBasedVehicle.getxPosition()-vehicle.getxPosition();
        double yDiff = this.seaBasedVehicle.getyPosition()-vehicle.getyPosition();

        return Math.sqrt(xDiff*xDiff+yDiff*yDiff);
    }


    /**
     * Checks if the vehicle is close enough to be loaded
     * @param vehicle the vehicle to be loaded
     * @return true if vehicle is close enough to be loaded
     */
    private boolean vehicleCloseEnough(C vehicle){
        double absDistance = getDistance(vehicle);
        return absDistance <= proximityThreshold;
    }


    /**
     * Loads the vehicle if the ramp is open, if its close enough to the ferry
     * and if it is under the weight limit.
     * @param vehicle the vehicle to be loaded
     */
    public void load(C vehicle) {
        if(isRampOpen()){
            if(vehicleCloseEnough(vehicle)){
                if(vehicle.getWeight() < cargoWeightLimit){
                    loader.load(vehicle);
                    synchronizeCargo();
                }
                else{
                    System.out.println("The vehicle is too large to load.");
                }
            }
            else{
                System.out.println("The vehicle must be closer in order to load it.");
            }
        }
        else{
            System.out.println("Ramp must be down in order to load the car.");
        }
    }


    /**
     * Unloads the ferry - first in, first out.
     * @return the vehicle that was unloaded or null if the ferry is empty
     */
    public C unload(){
        C vehicle = cargo.pop();
        try {
            vehicle.setxPosition(seaBasedVehicle.getxPosition()-0.1);
            vehicle.setyPosition(seaBasedVehicle.getyPosition()-0.1);
        } catch (NullPointerException e){
            System.out.println("Nothing to unload");
        }
        return vehicle;
    }

}
