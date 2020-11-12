import java.awt.*;

/**
 *  Represents the car Saab95.
 *
 */
public class Saab95 extends Cars{

    /**
     *  Keeps the value determenting if the turbo is on or off. (Default is on.)
     */

    private boolean turboOn;

    /**
     *  Constructs the car Saab95 by calling the super constructor in Cars.
     */
    public Saab95(){
        super(2, 125.0, 0.0, Color.red, "Saab95", 90, 0.0, 0.0);
        turboOn = false;
    }

    /**
     *  Turns on the turbo.
     */

    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Turns off the turbo
     */

    public void setTurboOff(){
	    turboOn = false;
    }

    /**
     * Calculates the speedfactor. ( which determines the speed trough incrementSpeed and decrementSpeed? )
     *
     * @return the calculated speedfactor.
     */
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    public static void main (String[] args) {
        Saab95 enSaab = new Saab95();
        Cars enVolvo = new Volvo240();

//        System.out.println(enSaab.yPosition);
//        System.out.println(enVolvo.yPosition);
//
//        enSaab.startEngine();
//        enVolvo.startEngine();
//        enSaab.move();
//        enVolvo.move();
//
//        System.out.println(enSaab.yPosition);
//        System.out.println(enVolvo.yPosition);
//
//        enSaab.turnLeft(); // 180 deg
//        enSaab.turnLeft(); // 270 deg
//        enSaab.move();
//        enSaab.move();
//        enSaab.move();
//        System.out.println(enSaab.yPosition);
//
//        enSaab.turnLeft(); // 0 deg
//        System.out.println(enSaab.direction);

    }
}
