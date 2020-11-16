import java.awt.*;

/**
 *  A class that represents the car model Volvo240. It's an extension of the Cars class.
 *
 * @author Arianit Zeqiri, Jakob Stråhle, Veronica Segerlind
 * @version 1.0
 */
public class Volvo240 extends Car {

    /**
     *  constant value 1.25 for the trim factor of the car.
     */
    private final static double trimFactor = 1.25;

    /**
     *  constructs the car Volvo240 by calling the super constructor in Cars.
     */
    public Volvo240(){
        super(4, 100.0, 0.0, Color.black, "Volvo240", 90, 0.0, 0.0);
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
