import java.awt.*;
/**
 *  A class that represents the Truck model Scania. It's an extension of the Truck class.
 *
 * @author Arianit Zeqiri, Jakob Stråhle, Veronica Segerlind
 * @version 1.0
 */
public class Scania extends Truck {
    /**
     * constructs the car Scania by calling the super constructor in Cars.
     */
    public Scania(){
        super(2, 100.0, 0.0, Color.blue, "Scania", 90, 0.0, 0.0, 10000, 0, 70);
    }

    /**
     * Constructs a new Scania for the given parameters.
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
     * @param weight a double that represents the weight of the car
     * @param minAngleTruckBed an int for the minimum angel of the truck bed
     * @param maxAngleTruckBed an int for the maximum angel of the truck bed
     */
    public Scania(int nrDoors, double enginePower, double currentSpeed,
                 Color color, String modelName, int direction,
                 double xPosition, double yPosition, double weight,
                 int minAngleTruckBed, int maxAngleTruckBed){
        super(nrDoors, enginePower, currentSpeed, color, modelName, direction,
                xPosition, yPosition, weight, minAngleTruckBed, maxAngleTruckBed);
    }

}
