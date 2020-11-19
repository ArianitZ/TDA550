import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestRamp {
    private Ramp ramp;

    @Before
    public void init(){
        ramp =new Ramp();
    }

    @Test
    public void TestRampDefault(){
        assertTrue(ramp.getRampAngle()==0 && ramp.getMinAngleRamp()==0 && ramp.getMaxAngleRamp()==45);
    }
}
