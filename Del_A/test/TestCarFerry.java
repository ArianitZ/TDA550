import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertTrue;
public class TestCarFerry {
    private CarFerry<Vehicle> ferry;
    private Saab95 saab;
    private Saab95 heavySaab;
    private Volvo240 volvo;

    @Before
    public void init(){
        ferry=new CarFerry<Vehicle>();
        saab = new Saab95();
        volvo = new Volvo240();
        heavySaab = new Saab95(2, 125.0, 0.0, Color.red, "Saab95", 90, 0.0, 0.0, 5000);
    }

    @Test
    public void testStartEngine(){
        ferry.startEngine();
        assertTrue(ferry.getCurrentSpeed() == 0.1);
    }
    @Test
    public void testStopEngine(){
        ferry.startEngine();
        ferry.gas(0.5);
        ferry.move();
        ferry.brake(0.6);
        ferry.move();
        ferry.stopEngine();
        assertTrue(ferry.getCurrentSpeed() == 0);
    }
    @Test
    public void testOpenRamp(){
        ferry.openRamp();
        assertTrue(ferry.isRampOpen());
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
        assertTrue(ferry.getCurrentSpeed() == 0);
    }
    @Test
    public void testCloseRamp(){
        ferry.openRamp();
        ferry.closeRamp();
        assertTrue(!ferry.isRampOpen());
    }
    @Test
    public void testLoadWithRampClosed(){
        ferry.load(saab);
        assertTrue(ferry.getCurrentLoadQuantity() == 0);
    }

    @Test
    public void testMoveAndTurns(){
        ferry.startEngine();
        ferry.move();
        ferry.turnLeft();
        ferry.move();
        ferry.turnRight();
        ferry.move();
        assertTrue(ferry.getxPosition() == -0.1
                && ferry.getyPosition() == 0.2
                && ferry.getDirection() == 90);
    }
    @Test
    public void testLoadCars(){
        ferry.openRamp();
        ferry.load(saab);
        ferry.load(saab);
        ferry.closeRamp();
        assertTrue(ferry.getCurrentLoadQuantity() == 2);
    }

    @Test
    public void testSyncronizedCargoWithFerry(){
        ferry.openRamp();
        saab.move();
        saab.turnRight();
        saab.move();
        ferry.load(saab);
        assertTrue(ferry.getxPosition() == saab.getxPosition()
                && ferry.getyPosition() == saab.getyPosition()
                && ferry.getDirection() == saab.getDirection());
    }
    @Test
    public void testIsCarsCloseEnough(){
        saab.startEngine();
        for(int i = 0; i < 12; i++){
            saab.move();
        }
        ferry.openRamp();
        ferry.load(saab);
        assertTrue(ferry.getCurrentLoadQuantity() == 0);
}
    @Test
    public void testLoadToHeavySaab(){
        ferry.openRamp();
        ferry.load(heavySaab);
        assertTrue(ferry.getCurrentLoadQuantity() == 0);
}
    @Test
    public void testMaxlimitCargo(){
        ferry.openRamp();
        for(int i = 0; i < 35; i++) {
            ferry.load(saab);
        }
        assertTrue(ferry.getCurrentLoadQuantity() == ferry.getMaxCapacity());
    }

    @Test
    public void testGetColorSetColorNrDoorsEnignepowerWeight(){
        ferry.setColor(Color.blue);
        assertTrue(ferry.getColor() == Color.blue);
        assertTrue(ferry.getNrDoors() == 2);
        assertTrue(ferry.getEnginePower() == 1000);
        assertTrue(ferry.getWeight()== 20000);
    }

    @Test
    public void testUnloadEmptyFerry(){
        ferry.openRamp();
        ferry.load(saab);
        ferry.unload();
        //ferry.unload();
        // TODO catch (StackEmptyException e) i CarFerry?
        assertTrue(ferry.getCurrentLoadQuantity() == 0);
}
    @Test
    public void testUnloadCarsInRightOrder(){
        ferry.openRamp();
        ferry.load(saab);
        ferry.load(volvo);
        ferry.unload();
        //TODO, hur kollar vi att volvon är kvar?
        // Eller att saaben blivit utlastad?
    }
    // TODO radera
    //  public double speedFactor(){return seaBasedVehicle.speedFactor();}
    //  ur CarFerry, änvänds väl inte?
}
