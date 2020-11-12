import java.awt.*;

/**
 * A class that represents the car model Saab95. It's an extension of the Cars class.
 *
 * @author Arianit Zeqiri, Jakob Stråhle, Veronica Segerlind
 * @version 1.0
 */
public class Saab95 extends Cars{

    /**
     *  keeps track of whether or not the turbo is on.
     *  Default value is off
     */
    private boolean turboOn;

    /**
     *  constructs the car Saab95 by calling the super constructor in Cars.
     */
    public Saab95(){
        super(2, 125.0, 0.0, Color.red, "Saab95", 90, 0.0, 0.0);
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
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}
