import org.junit.Before;
import org.junit.Test;
import java.awt.*;
import static org.junit.Assert.assertTrue;

public class TestVehicleColor {

    private Vehicle saab;
    private Vehicle volvo;

    @Before
    public void init(){
        saab = new Saab95();
        volvo = new Volvo240();
    }

    @Test
    public void testSetColorSaab(){
        Color color = Color.yellow;
        saab.setColor(color);

        assertTrue(saab.getColor().equals(color));
    }

    @Test
    public void testSetColorVolvo(){
        Color color = Color.yellow;
        volvo.setColor(color);

        assertTrue(volvo.getColor().equals(color));
    }


}
