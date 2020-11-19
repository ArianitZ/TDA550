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
        //System.out.println(scan.getTruckBedAngle());
        scan.startEngine();
        //System.out.println(scan.getCurrentSpeed());
        assertTrue(scan.getCurrentSpeed() == 0.0);

        /*
        TODO override startEngine i truck, så den inte startar med flak uppfällt, nu finns bara startEngine i Vehicle

        @Override
        public void startEngine(){
            if(truckBedAngle > minAngleTruckBed){
                System.out.println("You can't drive while having the truck bed raised");
                }
            else{ super.startEngine(); }
        }
         */


    }
    @Test
    public void testIncreaseTruckbedWhileMoving(){
        scan.startEngine();
        scan.increaseTruckBedAngle(10);
        assertTrue(scan.getTruckBedAngle() == 0);
    }

}
