import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TestVolvo240 {

    private Volvo240 volvo;

    @Before
    public void init(){
        volvo = new Volvo240();
    }

    @Test
    public void testSpeedFactor(){
        assertTrue(volvo.speedFactor() > 0.0);
    }
}
