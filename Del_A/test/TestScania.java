import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TestScania {

    private Scania scan;

    @Before
    public void init() { scan = new Scania(); }

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
