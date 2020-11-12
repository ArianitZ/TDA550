import java.awt.*;

public class Volvo240 extends Cars{

    private final static double trimFactor = 1.25;

    public Volvo240(){
        super(4, 100.0, 0.0, Color.black, "Volvo240", 90, 0.0, 0.0);

    }

    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
