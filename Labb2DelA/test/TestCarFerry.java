import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TestCarFerry {
    private CarFerry<Vehicle> ferry;
    private Vehicle seaBasedVehicle;
    private Vehicle volvo;
    private Vehicle scania;
    private Saab95 saab;

    @Before
    public void init(){
        ferry=new CarFerry<Vehicle>();
        seaBasedVehicle = new Vehicle(2,1000, 0.0, Color.white, "Båten", 90,
                0.0, 0.0, 20000);
        volvo = new Volvo240();
        scania = new Scania();
        saab = new Saab95();
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
    public void testStartEngine(){
        ferry.startEngine();
        assertTrue(ferry.getCurrentSpeed() == 0.1);
    }

    @Test
    public void testStopEngine(){
        ferry.startEngine();
        ferry.gas(0.5);
        ferry.move();
        ferry.brake(0.6);
        ferry.move();
        ferry.stopEngine();
        assertTrue(ferry.getCurrentSpeed() == 0);
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
    public void testMaxlimitCargo(){
        ferry.openRamp();
        for(int i = 0; i < 35; i++) {
            ferry.load(saab);
        }
        assertTrue(ferry.getCurrentLoadQuantity() == ferry.getMaxCapacity());
    }

    @Test
    public void TestFerryLoadCargoNotToHeavy(){
        ferry.openRamp();
        ferry.load(scania);
        assertTrue(ferry.getCurrentLoadQuantity() == 0);
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
    public void testMoveAndTurns(){
        ferry.startEngine();
        ferry.move();
        ferry.turnLeft();
        ferry.move();
        ferry.turnRight();
        ferry.move();
        assertTrue(ferry.getxPosition() == -0.1
                && ferry.getyPosition() == 0.2
                && ferry.getDirection() == 90);
    }

    @Test
    public void testSyncronizedCargoWithFerry(){
        ferry.openRamp();
        saab.move();
        saab.turnRight();
        saab.move();
        ferry.load(saab);
        assertTrue(ferry.getxPosition() == saab.getxPosition()
                && ferry.getyPosition() == saab.getyPosition()
                && ferry.getDirection() == saab.getDirection());
    }
    @Test
    public void testIsCarsCloseEnough(){
        saab.startEngine();
        for(int i = 0; i < 12; i++){
            saab.move();
        }
        ferry.openRamp();
        ferry.load(saab);
        assertTrue(ferry.getCurrentLoadQuantity() == 0);
    }
    @Test
    public void testLoadCars(){
        ferry.openRamp();
        ferry.load(saab);
        ferry.load(saab);
        ferry.closeRamp();
        assertTrue(ferry.getCurrentLoadQuantity() == 2);
    }

    @Test
    public void TestFerryUnload(){
        ferry.openRamp();
        ferry.load(volvo);
        ferry.unload();
        assertTrue(ferry.getCurrentLoadQuantity() == 0);
    }

    @Test
    public void testUnloadEmptyFerry(){
        ferry.openRamp();
        ferry.load(saab);
        ferry.unload();
        ferry.unload();
        assertTrue(ferry.getCurrentLoadQuantity() == 0);
    }
    @Test
    public void testUnloadCarsInRightOrder(){
        ferry.openRamp();
        ferry.load(saab);
        ferry.load(volvo);
        assertTrue(ferry.unload().equals(saab));
    }
}
