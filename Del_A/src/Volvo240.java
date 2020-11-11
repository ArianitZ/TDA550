import java.awt.*;

public class Volvo240 extends Cars{

    private final static double trimFactor = 1.25;
//(int nrDoors, double enginePower, double currentSpeed, Color color,
//                String modelName, int direction, double xPosition, double yPosition)
    public Volvo240(){
        super(4, 100.0, 0.0, Color.black, "Volvo240", 90, 0.0, 0.0);

    }

    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    protected void incrementSpeed(double amount){
        setCurrentSpeed( Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()) );
    }

    @Override
    protected void decrementSpeed(double amount){
        setCurrentSpeed( Math.max(getCurrentSpeed() - speedFactor() * amount,0) );
    }

}
