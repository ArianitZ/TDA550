import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TestCarFerry {
    private CarFerry<Vehicle> ferry;
    private Vehicle seaBasedVehicle;
    private Vehicle volvo;
    private Vehicle scania;

    @Before
    public void init(){
        ferry=new CarFerry<Vehicle>();
        seaBasedVehicle = new Vehicle(2,1000, 0.0, Color.white, "Båten", 90,
                0.0, 0.0, 20000);
        volvo = new Volvo240();
        scania = new Scania();
    }


    @Test
    public void TestStartEngineOpenRamp(){
        ferry.openRamp();
        ferry.startEngine();
        assertTrue(ferry.getCurrentSpeed() == 0.0);
    }

    @Test
    public void TestRamp(){
        ferry.openRamp();
        ferry.closeRamp();
        assertFalse(ferry.isRampOpen());
    }

    @Test
    public void TestgetCurrentLoadQuantity(){
        ferry.openRamp();
        ferry.load(volvo);
        assertTrue(ferry.getCurrentLoadQuantity() == 1);
    }

    @Test
    public void TestgetMaxCapacity(){
        assertTrue(ferry.getMaxCapacity() == 30);
    }

    @Test
    public void TestFerryTurnLeft(){
        ferry.turnLeft();
        assertTrue(ferry.getDirection() == 180);
    }

    @Test
    public void TestFerryTurnRight(){
        ferry.turnRight();
        assertTrue(ferry.getDirection() == 0);
    }

    @Test
    public void TestFerryMove(){
        double xPosition = ferry.getxPosition();
        double yPosition = ferry.getyPosition();
        ferry.startEngine();
        ferry.move();
        assertTrue(xPosition == ferry.getxPosition() && yPosition < ferry.getyPosition());
    }

    @Test
    public void TestFerryLoadRampOpen(){
        ferry.load(volvo);
        assertTrue(ferry.getCurrentLoadQuantity() == 0);
    }

    @Test
    public void TestFerryLoadCloseEnough(){
        volvo.startEngine();
        volvo.move();
        volvo.move();
        ferry.openRamp();
        ferry.load(volvo);
        assertTrue(ferry.getCurrentLoadQuantity() == 0);
    }

    @Test
    public void TestFerryLoadCargoNotToHeavy(){
        ferry.openRamp();
        ferry.load(scania);
        assertTrue(ferry.getCurrentLoadQuantity() == 0);
    }

    @Test
    public void TestFerryUnload(){
        ferry.openRamp();
        ferry.load(volvo);
        ferry.unload();
        assertTrue(ferry.getCurrentLoadQuantity() == 0);
    }

    @Test
    public void TestgetNrDoors(){
        assertTrue(ferry.getNrDoors()==2);
    }

    @Test
    public void TestGetEnginePowerFerry(){
        assertTrue(ferry.getEnginePower() == 1000);
    }
    @Test
    public void TestGetCurrentSpeedFerry(){
        assertTrue(ferry.getCurrentSpeed() == 0.0);
    }

    @Test
    public void TestGetColorFerry(){
        assertTrue(ferry.getColor().equals(Color.white));
    }

    @Test
    public void TestSetColorFerry(){
        ferry.setColor(Color.cyan);
        assertTrue(ferry.getColor().equals(Color.cyan));
    }

    @Test
    public void TestGetWeightFerry(){
        assertTrue(ferry.getWeight() == 20000);
    }

    @Test
    public void TestSpeedFactorFerry(){
        assertTrue(ferry.speedFactor() == ferry.getEnginePower()*0.01);
    }

    @Test
    public void TestStopEngineFerry(){
        ferry.startEngine();
        ferry.stopEngine();
        assertTrue(ferry.getCurrentSpeed() == 0.0);
    }

    @Test
    public void TestGasFerry(){
        ferry.startEngine();
        Double speed = ferry.getCurrentSpeed();
        ferry.gas(0.5);
        assertTrue(ferry.getCurrentSpeed()>speed);
    }

    @Test
    public void TestBrakeFerry(){
        ferry.gas(1);
        double Speed = ferry.getCurrentSpeed();
        ferry.brake(0.5);

        assertTrue(ferry.getCurrentSpeed() <= Speed);
    }

    @Test
    public void TestGetDirectionFerry(){
        assertTrue(ferry.getDirection()==90);
    }

    @Test
    public void TestGetxPositionFerry(){
        assertTrue(ferry.getxPosition() == 0.0);
    }

    @Test
    public void TestGetyPositionFerry(){
        assertTrue(ferry.getyPosition() == 0.0);
    }
}
