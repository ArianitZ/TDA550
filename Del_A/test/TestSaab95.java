import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TestSaab95 {

    private Saab95 saab;

    @Before
    public void init() {
        saab = new Saab95();
    }

    @Test
    public void testSetTurboOn(){
        saab.setTurboOn();

        assertTrue(saab.getTurboOn());
    }

    @Test
    public void testSetTurboOff(){
        saab.setTurboOn();
        saab.setTurboOff();

        assertTrue(!saab.getTurboOn());
    }

    @Test
    public void testSpeedFactor(){
        double initialSpeedFactor = saab.speedFactor();

        saab.setTurboOn();
        double changedSpeedFactor = saab.speedFactor();

        assertTrue(initialSpeedFactor != changedSpeedFactor);
    }

}
