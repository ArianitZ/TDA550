import java.awt.*;

public abstract class Cars implements Movable{

    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name

    protected int direction; // The direction of travel, in degrees. 0,90,180 or 270 degrees.
    protected double xPosition; // x-position of car
    protected double yPosition; // y-position of car

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }
///Jakob
    public Color getColor(){
        return color;
    }

    protected void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    protected abstract double speedFactor();

    protected void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    protected void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }

    public void move(){
        if (getCurrentSpeed() != 0.0)
        {
            switch(direction) {
                case 0:
                    xPosition = xPosition + getCurrentSpeed();
                    break;
                case 90:
                    yPosition = yPosition + getCurrentSpeed();
                    break;
                case 180:
                    xPosition = xPosition - getCurrentSpeed();
                    break;
                case 270:
                    yPosition = yPosition - getCurrentSpeed();
                    break;
                default:
                    System.out.println("Unknown direction");
            }
        }
    }

    public void turnLeft(){
        direction = (direction == 270) ? 0 : direction + 90;

    }
    public void turnRight(){
        direction = (direction == 0) ? 270 : direction - 90;
    }
}
