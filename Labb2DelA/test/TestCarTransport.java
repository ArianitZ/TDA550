import org.junit.Before;
        import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TestCarTransport {


    private CarTransport<Vehicle> transporter;
    private CarTransport<Vehicle> truck;
    private Saab95 saab;
    private Saab95 saab2;
    private Saab95 heavySaab;
    private Volvo240 volvo;

    @Before
    public void init() {
        saab = new Saab95();
        saab2 = new Saab95();
        heavySaab = new Saab95(2, 125.0, 0.0, Color.red, "Saab95", 90, 0.0, 0.0, 5000);
        volvo = new Volvo240(2, 125.0, 0.0, Color.red, "Volvo240", 90, 0.0, 0.0, 2000);
        transporter = new CarTransport();
        truck = new CarTransport(2, 100.0, 0.0, Color.blue, "Truck", 90, 0.0, 0.0,
                10000.0, 0, 45, 10, 3000);
    }

    @Test
    public void testOpenRamp() {
        truck.openRamp();
        assertTrue(truck.isRampOpen());
    }

    @Test
    public void testOpenRampWhileMoving(){
        transporter.startEngine();
        transporter.openRamp();
        assertTrue(!transporter.isRampOpen());
    }

    @Test
    public void testCloseRamp(){
        transporter.openRamp();
        transporter.closeRamp();
        assertTrue(transporter.isRampOpen() == false);
    }

    @Test
    public void testIsVehicleCloseEnough(){
        saab.move();
        transporter.openRamp();
        transporter.load(saab);
        assertTrue(saab.getxPosition() == transporter.getxPosition()
                && saab.getyPosition() == transporter.getyPosition());
        saab2.startEngine();
        saab2.move();
        saab2.move();
        transporter.load(saab2);
        assertTrue(saab2.getxPosition() != transporter.getxPosition()
                || saab2.getyPosition() != transporter.getyPosition());

    }

    @Test
    public void testLoadedCarCopiesPosition(){
        transporter.startEngine();
        transporter.move();
        saab.startEngine();
        saab.move();
        saab.move();
        transporter.stopEngine();
        transporter.openRamp();
        transporter.load(saab);
        assertTrue(saab.getxPosition() == transporter.getxPosition()
                && saab.getyPosition() == transporter.getyPosition());
     }

    @Test
    public void testMoveWithLoadedCargoAndCopyPositions(){
        transporter.openRamp();
        transporter.load(saab);
        transporter.closeRamp();
        transporter.move();
        transporter.turnLeft();
        transporter.move();
        transporter.turnRight();
        transporter.move();
        assertTrue(saab.getxPosition() == transporter.getxPosition()
                && saab.getyPosition() == transporter.getyPosition());
    }
    @Test
    public void testCargoMaxLimit(){
        transporter.openRamp();
        for(int i = 0; i < transporter.getMaxCapacity(); i++){
        transporter.load(saab);
        }
        transporter.load(saab);

        assertTrue(transporter.getCurrentLoadQuantity() == transporter.getMaxCapacity());
    }

    @Test
    public void testCargoMinLimit(){
        transporter.openRamp();
        transporter.load(saab);
        transporter.unload();
        transporter.unload();
        assertTrue(transporter.getCurrentLoadQuantity() == 0);
    }

    @Test
    public void testExtractingFromEmptyCargo(){
        transporter.openRamp();
       // transporter.unload(saab);
       // TODO skriva unloadmetoden
    }

    @Test
    public void testLoadWeightLimit(){
        saab.startEngine();
        transporter.openRamp();
        transporter.load(saab);
        transporter.load(volvo);
        int oldNumberOfVehicles = transporter.getCurrentLoadQuantity();
        transporter.load(heavySaab);
        assertTrue(oldNumberOfVehicles == transporter.getCurrentLoadQuantity());
    }

    @Test
    public void TestLoadRampDown(){
        transporter.load(saab);
        assertTrue(transporter.getCurrentLoadQuantity()==0);
    }

    @Test
    public void TestOpenRampWhiledriving(){
        transporter.startEngine();
        transporter.openRamp();
        assertFalse(transporter.isRampOpen());
    }

    @Test
    public void TestgetNrDoors(){
        assertTrue(truck.getNrDoors()==2);
    }

    @Test
    public void TestgetEnginePower(){
        assertTrue(truck.getEnginePower()==100);
    }

    @Test
    public void TestgetCurrentSpeed(){
        assertTrue(truck.getCurrentSpeed()==0);
    }

    @Test
    public void TestgetColor(){
        assertTrue(truck.getColor()==Color.blue);
    }

    @Test
    public void TestetColor(){
        truck.setColor(Color.yellow);
        assertTrue(truck.getColor()==Color.yellow);
    }

    @Test
    public void TestgetWeigh(){
        assertTrue(truck.getWeight()==10000.0);
    }

    @Test
    public void TestSpeedFactor(){
        assertTrue(truck.speedFactor()==truck.getEnginePower()*0.01);
    }

    @Test
    public void TestGas(){
        double oldSpeed = truck.getCurrentSpeed();
        truck.gas(0.5);
        double newSpeed = truck.getCurrentSpeed();

        assertTrue(newSpeed >= oldSpeed);
    }

    @Test
    public void TestBrake(){
        truck.gas(1);
        double oldSpeed = truck.getCurrentSpeed();
        truck.brake(0.5);
        double newSpeed = truck.getCurrentSpeed();

        assertTrue(newSpeed <= oldSpeed);
    }

    @Test
    public void TestgetDirection(){
        assertTrue(truck.getDirection()==90);
    }

}