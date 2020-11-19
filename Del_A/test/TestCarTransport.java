import org.junit.Before;
        import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertTrue;

public class TestCarTransport {

    CarTransport transporter = new CarTransport();
    Saab95 saab = new Saab95();
    Saab95 saab2 = new Saab95();
    Vehicle saabHeavy = new Saab95() {
    };

    @Before
    public void init() {
        saab = new Saab95();
        saab2 = new Saab95();
        transporter = new CarTransport();
    }

    @Test
    public void testOpenRamp() {
        transporter.openRamp();
        assertTrue(transporter.isRampOpen());
    }

    @Test
    public void testCloseRamp(){
        transporter.openRamp();
        transporter.closeRamp();
        assertTrue(transporter.isRampOpen() == false);
    }

    @Test
    public void testIsVehicleCloseEnough(){
        saab.move();
        transporter.openRamp();
        transporter.load(saab);
        assertTrue(saab.getxPosition() == transporter.getxPosition()
                && saab.getyPosition() == transporter.getyPosition());
        saab2.startEngine();
        saab2.move();
        saab2.move();
        transporter.load(saab2);
        assertTrue(saab2.getxPosition() != transporter.getxPosition()
                || saab2.getyPosition() != transporter.getyPosition());

    }

    @Test
    public void testLoadedCarCopiesPosition(){
        transporter.startEngine();
        transporter.move();
        saab.startEngine();
        saab.move();
        saab.move();
        transporter.stopEngine();
        transporter.openRamp();
        transporter.load(saab);
        assertTrue(saab.getxPosition() == transporter.getxPosition()
                && saab.getyPosition() == transporter.getyPosition());

        // TODO ändra CarTransport, vehicleCloseEnough {absDistance <= proximityThreshold;}
        //  (bara "<" innan) då blien rör sig 0.1 blir det dumt att ha en så liten marginal eller höj gränsen
    }

    @Test
    public void testMoveWithLoadedCargoAndCopyPositions(){
        transporter.openRamp();
        transporter.load(saab);
        transporter.closeRamp();
        transporter.move();
        transporter.turnLeft();
        transporter.move();
        transporter.turnRight();
        transporter.move();
        assertTrue(saab.getxPosition() == transporter.getxPosition()
                && saab.getyPosition() == transporter.getyPosition());
    }
    @Test
    public void testCargoQuantityLimit(){
        transporter.openRamp();
        for(int i = 0; i < 10; i++){
        transporter.load(saab);
        }
        //transporter.load(saab);
        //TODO, hur kollar man detta när list är och ska vara privat?
        // Låta println skriva ut från bortkommenterade raden?
    }
    @Test
    public void testExtractingFromEmptyCargo(){
        transporter.openRamp();
       // transporter.unload(saab);
       // TODO skriva unloadmetoden
    }
    @Test
    public void testLoadWeightLimit(){
        //TODO if-sats för viktgränsen, nu går det inte att skapa en tyngre Saab/Volvo i klasserna
        // lägga till konstruktor i Saab så man kan anropa Saab95(2, 125.0, 0.0, Color.red, "Saab95", 90, 0.0, 0.0, 5000000);
        saab.startEngine();
        transporter.openRamp();
        transporter.load(saab);
        transporter.closeRamp();
        transporter.startEngine();
        transporter.move();
       // assertTrue(saab.getxPosition() != transporter.getxPosition()
       //         || saab.getyPosition() != transporter.getyPosition());
    }
}