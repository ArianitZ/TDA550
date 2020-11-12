import java.awt.*;

/**
 * An abstract class used for modelling a car's structure as well as its driving behaviours.
 * @author Arianit Zeqiri, Jakob Stråhle
 * @version 1.0
 */
public abstract class Cars implements Movable{

    /**
     * the number of doors of the car
     */
    private int nrDoors;
    /**
     * the engine power of the car
     */
    private double enginePower;
    /**
     * the current speed of the car
     * The current speed must be between 0 and engine power
     */
    private double currentSpeed;
    /**
     * the color of the car
     */
    private Color color; // Color of the car
    /**
     * the model name of the car
     */
    private String modelName;

    /**
     * the direction of travel of the car, in degrees
     * Should be 0, 90, 180 or 270 degrees.
     */
    private int direction;
    /**
     * the x-position of the car
     */
    private double xPosition;
    /**
     * the y-position of the car
     */
    private double yPosition;

    /**
     * Constructs a new car for the given parameters.
     *
     * @param nrDoors an int representing the number of doors of the car
     * @param enginePower a double representing the engine power of the car
     * @param currentSpeed a double depicting the current speed of the car
     * @param color a Color object representing the color of the car
     * @param modelName a String containing the model name of the car
     * @param direction an int that keeps track of the direction of the car, in degrees. The car
     *                  can point in four directions: 0 degrees (East), 90 degrees (North),
     *                  180 degrees (West) and 270 degrees (South).
     * @param xPosition a double that keeps track of the x position of the car
     * @param yPosition a double that keeps track of the y position of the car
     */
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

    /**
     * returns the number of doors that the car has
     *
     * @return number of doors
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * returns the engine power of the car
     *
     * @return engine power of the car
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * returns the current speed of the car
     *
     * @return current speed of the car
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * returns the color of the car
     *
     * @return color of the car
     */
    public Color getColor(){
        return color;
    }

    /**
     * sets a new color for the car
     *
     * @param clr the desired color of the car
     */
    public void setColor(Color clr){
        color = clr;
    }

    /**
     * changes the current speed of the car
     *
     * @param speed the new speed of the car
     */
    public void setCurrentSpeed(double speed) { currentSpeed = speed; }

    /**
     * starts the engine of the car by setting the current speed to 0.1
     */
    public void startEngine(){
        setCurrentSpeed(0.1);
    }

    /**
     * stops the engine of the car by setting the current speed to 0
     */
    public void stopEngine(){
        setCurrentSpeed(0.0);
    }

    /**
     * returns the speed factor of the car
     *
     * @return the speed factor of the car
     */
    public abstract double speedFactor();

    /**
     * increments the current speed by the amount specified by the parameter amount
     * The method ensures that the current speed does not exceed engine power
     *
     * @param amount how much one wants to increase the speed of the car
     */
    private void incrementSpeed(double amount){
        double newSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
        setCurrentSpeed(newSpeed);
    }

    /**
     * decreases the current speed by the amount specified by the parameter amount
     * The method ensures that the current speed does not go below 0
     *
     * @param amount how much one wants to decrease the speed of the car
     */
    private void decrementSpeed(double amount){
        double newSpeed = Math.max( getCurrentSpeed() - speedFactor() * amount, 0);
        setCurrentSpeed( newSpeed );
    }

    /**
     * a method used to accelerate the car by increasing the speed of it by a certain amount
     * Only accepts values between 0 and 1
     *
     * @param amount a double representing how much one wants to increase the speed of the car
     */
    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    /**
     * a method used to decelerate the car by decreasing the speed of it by a certain amount
     * Only accepts values between 0 and 1
     *
     * @param amount a double representing how much one wants to decrease the speed of the car
     */
    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }

    /**
     * returns the current direction of the car
     *
     * @return an int representing the direction of the car
     */
    public int getDirection(){return direction;}

    /**
     * returns the current x-position of the car
     *
     * @return a double representing the x-position of the car
     */
    public double getxPosition(){return xPosition;}

    /**
     * returns the current y-position of the car
     *
     * @return a double representing the y-position of the car
     */
    public double getyPosition(){return yPosition;}

    /**
     *
     * @param newDirection
     */
    private void setDirection(int newDirection){ direction = newDirection; }

    /**
     *
     * @param newxPosition
     */
    private void setxPosition(double newxPosition) {xPosition = newxPosition;}

    /**
     *
     * @param newyPosition
     */
    private void setyPosition(double newyPosition) {yPosition = newyPosition;}

    /**
     *
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
     *
     */
    public void turnLeft(){
        int newDirection = (direction == 270) ? 0 : direction + 90;
        setDirection(newDirection);
    }

    /**
     *
     */
    public void turnRight(){
        int newDirection = (direction == 0) ? 270 : direction - 90;
        setDirection(newDirection);
    }

}
