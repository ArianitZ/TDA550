import java.awt.*;

/**
 * A class that represents the car model Saab95. It's an extension of the Cars class.
 *
 * @author Arianit Zeqiri, Jakob Stråhle, Veronica Segerlind
 * @version 1.0
 */
public class Saab95 extends Vehicle {

    /**
     *  keeps track of whether or not the turbo is on.
     *  Default value is off
     */
    private boolean turboOn;

    /**
     *  Default constructor for the car Saab95. Implemented by calling the super constructor in Cars.
     */
    public Saab95(){
        super(2, 125.0, 0.0, Color.red, "Saab95", 90, 0.0, 0.0, 2000);
        turboOn = false;
    }

    /**
     * Constructs a new Saab95 for the given parameters.
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
    public Saab95(int nrDoors, double enginePower, double currentSpeed, Color color,
                  String modelName, int direction, double xPosition, double yPosition,
                  double weight){

        super(nrDoors, enginePower, currentSpeed, color, modelName, direction, xPosition,
              yPosition, weight);
        turboOn = false;
    }

    /**
     *  turns on the turbo.
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * turns off the turbo
     */
    public void setTurboOff(){
	    turboOn = false;
    }

    /**
     * returns turbo status
     *
     * @return boolean of the turbo status
     */
    public boolean getTurboOn(){
        return turboOn;
    }

    /**
     * calculates the speed factor.
     * Speed factor is used to determine the new speed when using the methods
     * incrementSpeed and decrementSpeed.
     *
     * @return the calculated speed factor.
     */
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}
