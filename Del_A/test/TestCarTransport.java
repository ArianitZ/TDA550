import org.junit.Before;
        import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertTrue;

public class TestCarTransport {

    private CarTransport transporter;
    private Saab95 saab;
    private Saab95 saab2;
    private Saab95 heavySaab;

    @Before
    public void init() {
        saab = new Saab95();
        saab2 = new Saab95();
        heavySaab = new Saab95(2, 125.0, 0.0, Color.red, "Saab95", 90, 0.0, 0.0, 5000);
        transporter = new CarTransport();
    }

    @Test
    public void testOpenRamp() {
        transporter.openRamp();
        assertTrue(transporter.isRampOpen());
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
    public void testCargoQuantityLimit(){
        transporter.openRamp();
        for(int i = 0; i < transporter.getMaxCapacity(); i++){
        transporter.load(saab);
        }
        transporter.load(saab);

        assertTrue(transporter.getCurrentLoadQuantity() == transporter.getMaxCapacity());
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
        int oldNumberOfVehicles = transporter.getCurrentLoadQuantity();
        transporter.load(heavySaab);
        assertTrue(oldNumberOfVehicles == transporter.getCurrentLoadQuantity());
    }
}