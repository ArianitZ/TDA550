import java.util.ArrayList;
import java.util.List;
/**
 * A class that represents the car repair shop. It implemants Transporter.
 *
 * @author Arianit Zeqiri, Jakob Stråhle, Veronica Segerlind
 * @version 1.0
 */
public class CarRepairShop<V extends Vehicle> implements Transporter{

    /**
    * list that keeps track of loaded vehicles.
    */
    private List<V> listOfCars;

    /**
     *  Max capacity of the repair shop.
    **/

    private final int maxCapacity;

    /**
     *  loader of the car repair shop.
     */
    private Loader<V> repairShop;

    /**
     * x-position of the car repair shop.
     */
    private final double xPosition;

    /**
     * y-position of the car repair shop.
     */
    private final double yPosition;

    /**
     * direction of entrance of the car repair shop.
     */
    private final int directionOfEntrance;

    /**
     * constructs a new CarRepairShop with default parameters:
     *
     * param listOfCars
     * param maxCapacity = 10, representing the max value of the repair shops capacity.
     * param xPosition = 1, representing the x value of the repair shops position
     * param yPosition = 1, representing the y value of the repair shops position
     * param directionOfEntrance = 90, represents the angle direction of the repair shops entrance
     * param repairShop = new Loader, represents the loader of the repair shop.
     *
     */
    public CarRepairShop(){
        this.listOfCars = new ArrayList<>();
        maxCapacity = 10;
        xPosition = 1;
        yPosition = 1;
        directionOfEntrance = 90;
        repairShop = new Loader<>(listOfCars, maxCapacity);
    }

    /**
     * Returns the numbers of vehicles in the repair shop.
     * @return the number of vehicles in the repair shop.
     */
    public int getCargoQuantity(){
        return listOfCars.size();
    }

    /**
     * loads the vehicle into the repair shop. Changes the position of the vehicles to match the repair shops position.
     * @param car the cars thats gets loaded into the shop.
     */
    public void load(V car) {
        repairShop.load(car);
        synchronizeCargo(this);
    }

    /**
     * unloads the last vehicle thats been loaded into the shop. The unloaded car gets -0.1 in both x- and y-position
     * relative to the repair shops position.
     * @return the unloaded vehicle or null if list is empty.
     */
    public V unload() {
        V vehicle =  repairShop.unload();
        try{
            vehicle.setxPosition(vehicle.getxPosition()-0.1);
            vehicle.setyPosition(vehicle.getyPosition()-0.1);
        } catch (NullPointerException e){
            System.out.println("Nothing to unload");
        }
        return vehicle;
    }

    /**
     * synchronizes the vehicles to the repair shop when loading them.
     * @param t transporters (repair shops) positions.
     */
    private void synchronizeCargo(Transporter t) {
        repairShop.synchronizeCargo(t);
    }

    /**
     * gets the x-position of the repair shop.
     * @return x-position of repair shop.
     */
    @Override
    public double getxPosition() {
        return xPosition;
    }

    /**
     * gets the y-postition of the repair shop.
     * @return y-position of the repair shop.
     */
    @Override
    public double getyPosition() {
        return yPosition;
    }

    /**
     * gets the direction of the entrance of the repair shop.
     * @return direction of entrance of the repair shop.
     */
    @Override
    public int getDirection() {
        return directionOfEntrance;
    }
}
