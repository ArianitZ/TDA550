/**
 * A class that represents the ramp of a vehicle. Is supposed to be used together with a vehicle.
 *
 * @author Arianit Zeqiri, Jakob Stråhle, Veronica Segerlind
 * @version 1.0
 */
public class Ramp {

    /**
     * current rampangle
     */
    private int rampAngle;

    /**
     * maximum ramp angle
     */
    private int maxAngleRamp;

    /**
     * minimum ramp angle
     */
    private int minAngleRamp;


    /**
     * Default constructor for a ramp with the following default values.
     */
    public Ramp(){
        maxAngleRamp = 45;
        minAngleRamp = 0;
        rampAngle = 0;
    }


    /**
     *
     * @param maxAngleRamp int represent the maximum angle
     * @param minAngleRamp int representing the minimum angle
     */
    public Ramp(int maxAngleRamp, int minAngleRamp){
        this.rampAngle = minAngleRamp;
        this.maxAngleRamp = maxAngleRamp;
        this.minAngleRamp = minAngleRamp;
    }


    /**
     * returns the current truck bed angle
     * @return the current truck bed angle
     */
    public int getRampAngle() {return rampAngle;}


    /**
     * sets a new truck bed angle
     * @param newAngle the desired new angle
     */
    private void setRampAngle(int newAngle) {
        rampAngle = newAngle;}


    /**
     * getter for the maximum angle of the truck bed
     * @return the maximum angle of the truck bed
     */
    public int getMaxAngleRamp() { return maxAngleRamp;}


    /**
     * getter for the minimum angle of the truck bed
     * @return the minimum angle of the truck bed
     */
    public int getMinAngleRamp() { return minAngleRamp;}


    /**
     * Increases the truck bed angle with the amount specified.
     * If the car is moving the truck bed is not increased.
     * @param amount the amount one wants to increase the truck bed with
     * @param currentSpeed the curretn speed of the vehicle implementing this ramp
     */
    public void increaseRampAngle(int amount, double currentSpeed){
        if (currentSpeed == 0.0) {
            int newAngle = getRampAngle() + amount;
            newAngle = (newAngle < maxAngleRamp) ? newAngle : maxAngleRamp;
            setRampAngle(newAngle);
        }
        else{
            System.out.println("You can't increase the truck bed angle while moving!");
        }
    }


    /**
     * Decreases the truck bed angle with the amount specified
     * @param amount the amount one wants to decrease the truck bed with
     */
    public void decreaseRampAngle(int amount){
        int newAngle = getRampAngle() - amount;
        newAngle = (newAngle > minAngleRamp) ? newAngle: minAngleRamp;
        setRampAngle(newAngle);
    }

}
