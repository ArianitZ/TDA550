import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TestFerryRamp {
    private CarFerry<Vehicle> ferry;
    private Vehicle seaBasedVehicle;
    private Vehicle volvo;

    @Before
    public void init(){
        ferry=new CarFerry<Vehicle>();
        volvo = new Volvo240();
    }

    @Test
    public void testOpenRamp(){
        ferry.openRamp();
        assertTrue(ferry.isRampOpen());
    }
    @Test
    public void testCloseRamp(){
        ferry.openRamp();
        ferry.closeRamp();
        assertTrue(!ferry.isRampOpen());
    }

    @Test
    public void testOpenRampWhileMoving(){
        ferry.startEngine();
        ferry.openRamp();
        assertTrue(!ferry.isRampOpen());

    }
    @Test
    public void testStartWithRampOpen(){
        ferry.openRamp();
        ferry.startEngine();
        assertTrue(ferry.getCurrentSpeed() == 0.0);
    }

    @Test
    public void testLoadWithRampClosed(){
        ferry.load(volvo);
        assertTrue(ferry.getCurrentLoadQuantity() == 0);
    }

    @Test
    public void TestFerryLoadRampOpen(){
        ferry.openRamp();
        ferry.load(volvo);
        assertTrue(ferry.getCurrentLoadQuantity() == 1);
    }
}
