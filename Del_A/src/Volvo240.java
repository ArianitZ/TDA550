import java.awt.*;

/**
 *  A class that represents the car model Volvo240. It's an extension of the Cars class.
 *
 * @author Arianit Zeqiri, Jakob Stråhle, Veronica Segerlind
 * @version 1.0
 */
public class Volvo240 extends Vehicle {

    /**
     *  constant value 1.25 for the trim factor of the car.
     */
    private final static double trimFactor = 1.25;

    /**
     *  constructs the car Volvo240 by calling the super constructor in Cars.
     */
    public Volvo240(){
        super(4, 100.0, 0.0, Color.black, "Volvo240", 90, 0.0, 0.0, 1500);
    }

    /**
     * Constructs a new Volvo240 for the given parameters.
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
     */
    public Volvo240(int nrDoors, double enginePower, double currentSpeed, Color color,
                  String modelName, int direction, double xPosition, double yPosition,
                  double weight){
        super(nrDoors, enginePower, currentSpeed, color, modelName, direction, xPosition,
                yPosition, weight);
    }

    /**
     * calculates the speed factor.
     * Speed factor is used to determine the new speed when using the methods
     * incrementSpeed and decrementSpeed.
     *
     * @return the calculated speed factor.
     */
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

}
