import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertTrue;

public class TestRamp {
    private Ramp ramp;

    @Before
    public void init(){
        ramp =new Ramp();
    }

    @Test
    public void TestRampDefault(){
        assertTrue(ramp.getTruckBedAngle()==0 && ramp.getMinAngleTruckBed()==0 && ramp.getMaxAngleTruckBed()==45);
    }
}
