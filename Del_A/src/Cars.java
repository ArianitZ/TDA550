import java.awt.*;

/**
 *
 * param
 */

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

//tvingar alla sub till cars att implemetera

    protected void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    protected void decrementSpeed(double amount){
                  setCurrentSpeed( getCurrentSpeed() - speedFactor() * amount );
        //        setCurrentSpeed( Math.max(getCurrentSpeed() - speedFactor() * amount,0) );
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

    /**
     *  Sets the new direction of the object.
     * @param newDirection the new direction.
     */

    private void setDirection(int newDirection){ direction = newDirection; }

    /**
     * Sets the new position on the x-axis of the object.
     * @param newxPosition the new postion on the x-axis.
     */
    private void setxPosition(double newxPosition) {xPosition = newxPosition;}

    /**
     *  Sets the new position on the y-axis of the object.
     * @param newyPosition the new postion on the y-axis.
     */

    private void setyPosition(double newyPosition) {yPosition = newyPosition;}


    /**
     *  Moves the object if the object have any current speed. Where the object is moves is determined by the value of its direction and current speed.
     */
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

    /**
     * Turns the object 90 degrees to the left from its current direction.
     */
    public void turnLeft(){
        int newDirection = (direction == 270) ? 0 : direction + 90;
        setDirection(newDirection);
    }

    /**
     * Turns the object 90 degrees to the right from its current direction.
     */
    public void turnRight(){
        int newDirection = (direction == 0) ? 270 : direction - 90;
        setDirection(newDirection);
    }

}
