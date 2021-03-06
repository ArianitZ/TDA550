import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestScania {

    private Scania scan;

    @Before
    public void init() { scan = new Scania(2, 100.0, 0.0, Color.blue, "Scania", 90, 0.0, 0.0, 10000, 0, 70);}

    @Test
    public void testTruckBedIncrease(){
        scan.increaseTruckBedAngle(20);
        assertTrue(scan.getTruckBedAngle() == 20);
    }

    @Test
    public void testTruckbedDecrease(){
        scan.increaseTruckBedAngle(70);
        scan.decreaseTruckBedAngle(45);
        assertTrue(scan.getTruckBedAngle() == 25);

    }

    @Test
    public void testTruckbedLimits(){
        scan.increaseTruckBedAngle(100);
        assertTrue(scan.getTruckBedAngle() == 70);
        scan.decreaseTruckBedAngle(80);
        assertTrue(scan.getTruckBedAngle() == 0);
    }

    @Test
    public void testMoveWithTruckbedUp(){
        scan.increaseTruckBedAngle(10);
        scan.startEngine();
        assertTrue(scan.getCurrentSpeed() == 0.0);

    }
    @Test
    public void testIncreaseTruckbedWhileMoving(){
        scan.startEngine();
        scan.increaseTruckBedAngle(10);
        assertTrue(scan.getTruckBedAngle() == 0);
    }

}
