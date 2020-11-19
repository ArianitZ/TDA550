import java.awt.*;
/**
 * A class that represents the internal structure of a truck and its driving behaviour
 *  It's a subclass of the vehicles class.
 *
 * @author Arianit Zeqiri, Jakob Stråhle, Veronica Segerlind
 * @version 1.0
 */
public class Truck extends Vehicle{

    /**
     * a truckBed of type Ramp - used for delegating the methods of a truck bed to a Ramp object
     */
    private final Ramp truckBed;

    /**
     * Constructs a new car for the given parameters.
     *
     * @param nrDoors an int representing the number of doors of the car
     * @param enginePower a double representing the engine power of the car
     * @param currentSpeed a double depicting the current speed of the car
     * @param color a Color object representing the color of the car
     * @param modelName a String containing the model name of the car
     * @param direction an int that keeps track of the direction of the car, in degrees. The car
     *                  can point in four directions: 0 degrees (East), 90 degrees (North),
     *                  180 degrees (West) and 270 degrees (South).
     * @param xPosition a double that keeps track of the x position of the car
     * @param yPosition a double that keeps track of the y position of the car
     * @param weight    a double that represents the weight of the car
     * @param minAngleTruckBed an int that represents the lowest angle of the truck bed
     * @param maxAngleTruckBed an int that represents the highest angle of a truck bed
     */
    public Truck(int nrDoors, double enginePower, double currentSpeed,
                 Color color, String modelName, int direction,
                 double xPosition, double yPosition, double weight,
                 int minAngleTruckBed, int maxAngleTruckBed){
        super(nrDoors, enginePower, currentSpeed, color, modelName, direction,
                xPosition, yPosition, weight);
        truckBed = new Ramp(maxAngleTruckBed, minAngleTruckBed);
    }

    /**
     *  returns the current truck bed angle
     * @return the current truck bed angle
     */
    public int getTruckBedAngle() {return truckBed.getRampAngle();}

    /**
     * returns the maximum truck bed angle
     * @return the maximum truck bed angle
     */
    public int getMaxAngleTruckBed() { return truckBed.getMaxAngleRamp();}

    /**
     * returns the minimum truck bed angle
     * @return the minimum truck bed angle
     */
    public int getMinAngleTruckBed() { return truckBed.getMinAngleRamp();}

    /**
     * increases the truck bed angle by the amount specified
     * @param amount the amount one wants to increase the truck bed angle
     */
    public void increaseTruckBedAngle(int amount){
        truckBed.increaseRampAngle(amount, this.getCurrentSpeed());
    }

    /**
     * decreases the truck bed angle by the amount specified
     * @param amount the amount one wants to decrease the truck bed angle
     */
    public void decreaseTruckBedAngle(int amount){
        truckBed.decreaseRampAngle(amount);
    }

    /**
     * Starts the engine of the truck.
     * The truck can't be started if the truck bed is raised.
     */
    @Override
    public void startEngine(){
        if(truckBed.getRampAngle() > truckBed.getMinAngleRamp()){
            System.out.println("You can't drive while having the truck bed raised");
        }
        else{ super.startEngine(); }
    }

    /**
     * Moves the truck.
     * The truck cant be moved if the truck bed is raised.
     */
    @Override
    public void move(){
        if(truckBed.getRampAngle() > truckBed.getMinAngleRamp()){
            System.out.println("You can't drive while having the truck bed raised");
        }
        else{
            super.move();
        }
    }

}
