import org.junit.Before;
import org.junit.Test;
import java.awt.*;
import static org.junit.Assert.assertTrue;

public class TestCarGetters {

    private Car saab;
    private Car volvo;

    @Before
    public void init(){
        saab = new Saab95();
        volvo = new Volvo240();
    }


    @Test
    public void testGetNrDoorsSaab(){
        assertTrue(saab.getNrDoors() == 2);
    }

    @Test
    public void testGetNrDoorsVolvo(){
        assertTrue(volvo.getNrDoors() == 4);
    }


    @Test
    public void testGetEnginePowerSaab(){
        assertTrue(saab.getEnginePower() == 125.0);
    }

    @Test
    public void testGetEnginePowerVolvo(){
        assertTrue(volvo.getEnginePower() == 100.0);
    }


    @Test
    public void testGetColorSaab(){
        assertTrue(saab.getColor().equals(Color.red));
    }

    @Test
    public void testGetColorVolvo(){
        assertTrue(volvo.getColor().equals(Color.black));
    }


    @Test
    public void testGetCurrentSpeedSaab(){
        assertTrue(saab.getCurrentSpeed() == 0.0);
    }

    @Test
    public void testGetCurrentSpeedVolvo(){
        assertTrue(volvo.getCurrentSpeed() == 0.0);
    }

    @Test
    public void testGetDirectionSaab(){
        assertTrue(saab.getDirection() == 90);
    }

    @Test
    public void testGetDirectionVolvo(){
        assertTrue(volvo.getDirection() == 90);
    }

    @Test
    public void testGetxPositionSaab(){
        assertTrue(saab.getxPosition() == 0.0);
    }

    @Test
    public void testGetxPositionVolvo(){
        assertTrue(volvo.getxPosition() == 0.0);
    }

    @Test
    public void testGetyPositionSaab(){
        assertTrue(saab.getyPosition() == 0.0);
    }

    @Test
    public void testGetyPositionVolvo(){
        assertTrue(volvo.getyPosition() == 0.0);
    }
}
