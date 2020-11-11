import java.awt.*;

public abstract class Cars implements Movable{

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    private int direction; // The direction of travel, in degrees. 0,90,180 or 270 degrees.
    private double xPosition; // x-position of car
    private double yPosition; // y-position of car

    public Cars(int nrDoors, double enginePower, double currentSpeed, Color color,
                String modelName, int direction, double xPosition, double yPosition)
    {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;

        this.direction = direction;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

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

    public void setColor(Color clr){
        color = clr;
    }

    public void setCurrentSpeed(double speed) { currentSpeed = speed; }

    public void startEngine(){
        setCurrentSpeed(0.1);
    }

    public void stopEngine(){
        setCurrentSpeed(0.0);
    }

    protected abstract double speedFactor();

    protected void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    protected void decrementSpeed(double amount){
        setCurrentSpeed( getCurrentSpeed() - speedFactor() * amount );
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }

    public int getDirection(){return direction;}

    public double getxPosition(){return xPosition;}

    public double getyPosition(){return yPosition;}

    private void setDirection(int newDirection){ direction = newDirection; }

    private void setxPosition(double newxPosition) {xPosition = newxPosition;}

    private void setyPosition(double newyPosition) {yPosition = newyPosition;}

    public void move(){
        if (getCurrentSpeed() != 0.0)
        {
            switch(getDirection()) {
                case 0:
                    setxPosition(getxPosition() + getCurrentSpeed());
                    break;
                case 90:
                    setyPosition(getyPosition() + getCurrentSpeed());
                    break;
                case 180:
                    setxPosition(getxPosition() - getCurrentSpeed());
                    break;
                case 270:
                    setyPosition(getyPosition() - getCurrentSpeed());
                    break;
                default:
                    System.out.println("Unknown direction");
            }
        }
    }

    public void turnLeft(){
        int newDirection = (direction == 270) ? 0 : direction + 90;
        setDirection(newDirection);
    }

    public void turnRight(){
        int newDirection = (direction == 0) ? 270 : direction - 90;
        setDirection(newDirection);
    }

}
