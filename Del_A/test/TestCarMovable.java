import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class TestCarMovable {

    private Car volvo;

    @Before
    public void init(){
        volvo = new Volvo240();
    }

    @Test
    public void testTurnLeft(){
        int oldDirection = volvo.getDirection();
        volvo.turnLeft();

        assertTrue(oldDirection+90 == volvo.getDirection());
    }

    @Test
    public void testTurnRight(){
        int oldDirection = volvo.getDirection();
        volvo.turnRight();

        assertTrue(oldDirection-90 == volvo.getDirection());
    }

    @Test
    public void testTurnLeft360Degrees(){
        int oldDirection = volvo.getDirection();
        volvo.turnLeft();
        volvo.turnLeft();
        volvo.turnLeft();
        volvo.turnLeft();

        assertTrue(oldDirection == volvo.getDirection());
    }

    @Test
    public void testTurnRight360Degrees(){
        int oldDirection = volvo.getDirection();
        volvo.turnRight();
        volvo.turnRight();
        volvo.turnRight();
        volvo.turnRight();

        assertTrue(oldDirection == volvo.getDirection());
    }


    @Test
    public void testMove(){
        double oldxPosition = volvo.getxPosition();
        double oldyPosition = volvo.getyPosition();

        volvo.startEngine();
        volvo.move();

        double newxPosition = volvo.getxPosition();
        double newyPosition = volvo.getyPosition();

        assertTrue(oldxPosition == newxPosition && oldyPosition < newyPosition);
    }

    @Test
    public void testMoveUpMoveLeft(){
        double oldxPosition = volvo.getxPosition();
        double oldyPosition = volvo.getyPosition();

        volvo.startEngine();
        volvo.move();

        volvo.turnLeft();
        volvo.move();

        double newxPosition = volvo.getxPosition();
        double newyPosition = volvo.getyPosition();

        assertTrue(oldxPosition > newxPosition && oldyPosition < newyPosition);
    }

    @Test
    public void testMoveUpMoveRight(){
        double oldxPosition = volvo.getxPosition();
        double oldyPosition = volvo.getyPosition();

        volvo.startEngine();
        volvo.move();

        volvo.turnRight();
        volvo.move();

        double newxPosition = volvo.getxPosition();
        double newyPosition = volvo.getyPosition();

        assertTrue(oldxPosition < newxPosition && oldyPosition < newyPosition);
    }

    @Test
    public void testMoveInACricle(){
        double oldxPosition = volvo.getxPosition();
        double oldyPosition = volvo.getyPosition();
        int oldDirection = volvo.getDirection();

        volvo.startEngine();
        volvo.turnRight();
        volvo.move();

        volvo.turnLeft();
        volvo.move();

        volvo.turnLeft();
        volvo.move();

        volvo.turnLeft();
        volvo.move();

        double newxPosition = volvo.getxPosition();
        double newyPosition = volvo.getyPosition();
        int newDirection = volvo.getDirection();

        assertTrue(oldxPosition == newxPosition && oldyPosition == newyPosition &&
                   newDirection-180 == oldDirection);
    }

}
