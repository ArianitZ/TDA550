import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestTruck {

    private Truck scania;

    @Before
    public void init(){
        scania = new Scania();
    }

    @Test
    public void TestgetTruckBedAngel(){
        assertTrue(scania.getTruckBedAngle()==0);
    }

    //TODO change if changed
    @Test
    public  void TestSpeedFactor(){
        assertTrue(scania.speedFactor()==scania.getEnginePower()*0.01);
    }

    @Test
    public void TestMaxTruckBedAngel(){
        assertTrue(scania.getMaxAngleTruckBed()==70);
    }

    @Test
    public void TestMinTruckBedAngel(){
        assertTrue(scania.getMinAngleTruckBed()==0);
    }

    @Test
    public void testincreseTruckBedAngelWhiledriving(){
        scania.startEngine();
        scania.increaseTruckBedAngle(10);
        assertTrue(scania.getTruckBedAngle()==0);
    }

    @Test
    public void testincreseTruckBedAngel(){
        scania.increaseTruckBedAngle(10);
        assertTrue(scania.getTruckBedAngle()==10);
    }

    @Test
    public void testincreseTruckBedAngelMax(){
        scania.increaseTruckBedAngle(80);
        assertTrue(scania.getTruckBedAngle()==70);
    }

    @Test
    public void testdecreseTruckBedAngel(){
        scania.increaseTruckBedAngle(50);
        scania.decreaseTruckBedAngle(10);
        assertTrue(scania.getTruckBedAngle()==40);
    }

    @Test
    public void testdecreseTruckBedAngelMin(){
        scania.decreaseTruckBedAngle(10);
        assertTrue(scania.getTruckBedAngle()==0);
    }


    //TODO fix when speed is fixed
    @Test
    public void TestStartEngine(){
        scania.startEngine();
        assertTrue(scania.getCurrentSpeed()==0.1);
    }

    @Test
    public void TestStartEngineTruckOpen(){
        scania.increaseTruckBedAngle(70);
        scania.startEngine();
        assertTrue(scania.getCurrentSpeed()==0.0);
    }

    @Test
    public void TestMove(){
        scania.startEngine();
        scania.move();
        assertFalse(scania.getxPosition() == 0.0 && scania.getyPosition() == 0.0);
    }

    @Test
    public void TestMoveTruckOpen(){
        scania.increaseTruckBedAngle(70);
        scania.startEngine();
        scania.move();
        assertTrue(scania.getxPosition()==0.0 && scania.getyPosition()==0.0);
    }
}
