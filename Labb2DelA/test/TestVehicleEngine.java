import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertTrue;


public class TestVehicleEngine {

    private Vehicle saab;
    private Vehicle vehicle;


    @Before
    public void init(){
        saab = new Saab95();
        vehicle = new Vehicle(4, 125.0, 0.0, Color.red, "Saab95", 90, 0.0, 0.0, 2000);
    }

    @Test
    public void testStartEngine(){
        saab.startEngine();
        assertTrue(saab.getCurrentSpeed() == 0.1);
    }

    @Test
    public void testStopEngine(){
        saab.startEngine();
        saab.stopEngine();
        assertTrue(saab.getCurrentSpeed() == 0.0);
    }

    @Test
    public void testGas(){
        double oldSpeed = saab.getCurrentSpeed();
        saab.gas(0.5);
        double newSpeed = saab.getCurrentSpeed();

        assertTrue(newSpeed >= oldSpeed);
    }

    @Test
    public void testGasUpperLimit(){
        double oldSpeed = saab.getCurrentSpeed();
        saab.gas(1.1);
        double newSpeed = saab.getCurrentSpeed();

        assertTrue(newSpeed == oldSpeed);
    }

    @Test
    public void testGasLowerLimit(){
        double oldSpeed = saab.getCurrentSpeed();
        saab.gas(-1);
        double newSpeed = saab.getCurrentSpeed();

        assertTrue(newSpeed == oldSpeed);
    }


    @Test
    public void testBrake(){
        saab.gas(1);
        double oldSpeed = saab.getCurrentSpeed();
        saab.brake(0.5);
        double newSpeed = saab.getCurrentSpeed();

        assertTrue(newSpeed <= oldSpeed);
    }

    @Test
    public void testBrakeUpperLimit(){
        saab.gas(1);
        double oldSpeed = saab.getCurrentSpeed();
        saab.brake(2);
        double newSpeed = saab.getCurrentSpeed();
        assertTrue(newSpeed == oldSpeed);
    }

    @Test
    public void testBrakeLowerLimit(){
        saab.gas(1);
        double oldSpeed = saab.getCurrentSpeed();
        saab.brake(-1);
        double newSpeed = saab.getCurrentSpeed();
        assertTrue(newSpeed == oldSpeed);
    }

    @Test
    public void TestSpeedfactor(){
        assertTrue(vehicle.speedFactor()==vehicle.getEnginePower()*0.01);
    }

}
