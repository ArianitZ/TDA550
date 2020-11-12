import java.awt.*;

/**
 *  Represents the car Saab95.
 *
 */
public class Volvo240 extends Cars{

    /**
     *  Keeps final value 1.25 for the trimfactor of the car.
     */

    private final static double trimFactor = 1.25;

    /**
     *  Constructs the car Volvo240 by calling the super constructor in Cars.
     */
    public Volvo240(){
        super(4, 100.0, 0.0, Color.black, "Volvo240", 90, 0.0, 0.0);

    }
    /**
     * Calculates the speedfactor. ( which determines the speed trough incrementSpeed and decrementSpeed? )
     *
     * @return the calculated speedfactor.
     */
    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    /**
     * Calculates and sets the new current speed for the car.
     *
     * @param amount, the amount of gas
     */
    @Override
    protected void incrementSpeed(double amount){
        setCurrentSpeed( Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()) );
    }

    /**
     *  Caluculates and sets the new current speed for the car.
     *
     * @param amount, the amount of brake.
     */
    @Override
    protected void decrementSpeed(double amount){
        setCurrentSpeed( Math.max(getCurrentSpeed() - speedFactor() * amount,0) );
    }

}
