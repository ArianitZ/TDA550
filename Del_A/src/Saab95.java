import java.awt.*;

public class Saab95 extends Cars{

    private boolean turboOn;
    
    public Saab95(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
	    turboOn = false;
        modelName = "Saab95";
        stopEngine();

        xPosition = 0.0;
        yPosition = 0.0;
        direction = 90;

    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    public static void main (String[] args) {
        Saab95 enSaab = new Saab95();
        Cars enVolvo = new Volvo240();

        System.out.println(enSaab.yPosition);
        System.out.println(enVolvo.yPosition);

        enSaab.startEngine();
        enVolvo.startEngine();
        enSaab.move();
        enVolvo.move();

        System.out.println(enSaab.yPosition);
        System.out.println(enVolvo.yPosition);

        enSaab.turnLeft(); // 180 deg
        enSaab.turnLeft(); // 270 deg
        enSaab.move();
        enSaab.move();
        enSaab.move();
        System.out.println(enSaab.yPosition);

        enSaab.turnLeft(); // 0 deg
        System.out.println(enSaab.direction);
    }
}
