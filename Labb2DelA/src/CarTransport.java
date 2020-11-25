import java.awt.*;
import java.util.ArrayList;
/**
 * A class that represents the car transport.
 *
 * @author Arianit Zeqiri, Jakob Stråhle, Veronica Segerlind
 * @version 1.0
 */

public class CarTransport<V extends Vehicle>{
    /**
     * creates an object truck.
     */
    private final Truck truck;
    /**
     * loader of the car transport.
     */
    private final Loader<V> cargo;

    /**
     * List that keeps track on the loaded cars.
     */
    private final ArrayList<V> listOfVehicles;

    /**
     * max capacity of the car transport.
     */
    private final int maxCapacity;

    /**
     * weight limit of the cargo that gets loaded on the car transport.
     */
    private final double cargoWeightLimit;

    /**
     * max distance from the car that will get loaded to the car transport.
     */
    private double proximityThreshold;

    /**
     * constructs a CarTransport by calling the constructor in the class Truck.
     */
    public CarTransport(){
        truck = new Truck(2, 100.0, 0.0, Color.blue, "Truck", 90, 0.0, 0.0,
                          10000.0, 0, 45);
        listOfVehicles = new ArrayList<>();
        maxCapacity = 10;
        cargo = new Loader<>(listOfVehicles, maxCapacity);
        proximityThreshold = 0.1;
        cargoWeightLimit = 3000;
    }
    /**
     * Constructs a new CarTransport for the given parameters.
     * @param nrDoors an int representing the number of doors of the car transport
     * @param enginePower a double representing the engine power of the car transport
     * @param currentSpeed a double depicting the current speed of the car transport
     * @param color a Color object representing the color of the car transport
     * @param modelName a String containing the model name of the car transport
     * @param direction an int that keeps track of the direction of the car transport, in degrees. The car transport
     *                  can point in four directions: 0 degrees (East), 90 degrees (North),
     *                  180 degrees (West) and 270 degrees (South).
     * @param xPosition a double that keeps track of the x position of the car transport
     * @param yPosition a double that keeps track of the y position of the car transport
     * @param weight    a double that represents the weight of the car transport
     * @param minAngle an int that keeps track of the minimum angle of the ramp of the car transport
     * @param maxAngle an int that keeps track of the maximum angle of the ramp of the car transport
     */
    public CarTransport(int nrDoors, double enginePower, double currentSpeed,
                        Color color, String modelName, int direction,
                        double xPosition, double yPosition, double weight,
                        int minAngle, int maxAngle, int maxCapacity, double cargoWeightLimit){
        truck = new Truck(nrDoors, enginePower, currentSpeed, color, modelName, direction,
                          xPosition, yPosition, weight, minAngle, maxAngle);
        listOfVehicles = new ArrayList<>();
        this.maxCapacity = maxCapacity;
        cargo = new Loader<>(listOfVehicles, this.maxCapacity);
        this.cargoWeightLimit = cargoWeightLimit;
    }

    /**
     * gets the number of doors of the car transport
     * @return the numbers of doors.
     */
    public int getNrDoors(){
        return truck.getNrDoors();
    }

    /**
     * gets the engine power of the car transport
     * @return the engine power
     */
    public double getEnginePower(){
        return truck.getEnginePower();
    }

    /**
     * gets the current speed of the car transport
     * @return the current speed
     */
    public double getCurrentSpeed(){
        return truck.getCurrentSpeed();
    }

    /**
     * gets the color of the car transport
     * @return the color of the car transport
     */
    public Color getColor(){
        return truck.getColor();
    }

    /**
     * sets the color of the car transport
     * @param clr Color.color of the new paint of the car transport
     */
    public void setColor(Color clr){ truck.setColor(clr); }

    /**
     * gets the weight of the car transport
     * @return the weight of the car transport
     */
    public double getWeight(){ return truck.getWeight();}

    /**
     * starts the engine of the car transport
     */
    public void startEngine(){ truck.startEngine(); }

    /**
     * calculates the speedfactor of the car transport
     * @return the speed factor of the car transport
     */
    public double speedFactor(){return getEnginePower()*0.01;}

    /**
     * stops the engine of the car transport
     */
    public void stopEngine(){
        truck.stopEngine();
    }

    /**
     * increses the speed of the car transport
     * @param amount of gas to the car transport
     */
    public void gas(double amount){ truck.gas(amount); }

    /**
     * decreases the speed of the car transport
     * @param amount of brake to the car transport
     */
    public void brake(double amount){ truck.brake(amount);}

    /**
     * gets the direction of the car transport
     * @return the direction of the car transport
     */
    public int getDirection(){return truck.getDirection();}

    /**
     * gets the x-position of the car transport
     * @return the x-position of the car transport
     */
    public double getxPosition(){return truck.getxPosition();}

    /**
     * gets the y-position of the car transport
     * @return
     */
    public double getyPosition(){return truck.getyPosition();}

    /**
     * gets the current number of cars loaded to the car transport
     * @return number of cars
     */
    public int getCurrentLoadQuantity(){
        return listOfVehicles.size();
    }

    /**
     * gets the max capacity of the car transport
     * @return max capacity of the car transport
     */
    public int getMaxCapacity(){
        return maxCapacity;
    }

    /**
     * turns the car transport and the loaded cars to the left, 90 degrees.
     */
    public void turnLeft(){
        truck.turnLeft();
        synchronizeCargo();
    }

    /**
     * turns the car transport and the loaded cars to the right, 90 degress.
     */
    public void turnRight(){
        truck.turnRight();
        synchronizeCargo();
    }

    /**
     * moves the car transport and the loaded cars in the direction of the car transport.
     */
    public void move(){
        truck.move();
        synchronizeCargo();
    }

    /**
     * synchronizes the loaded cars with the car transport
     */
    private void synchronizeCargo(){
        cargo.synchronizeCargo(truck);
    }

    /**
     * opens up the ramp to the car transport, the car transport has to be still to do so.
     */
    public void openRamp(){
        if(truck.getCurrentSpeed() == 0.0){
            truck.increaseTruckBedAngle(truck.getMaxAngleTruckBed());
        }
        else{
            System.out.println("You cant open the ramp while driving.");
        }
    }

    /**
     * closes the ramp to the car transport.
     */
    public void closeRamp(){
        truck.decreaseTruckBedAngle(truck.getMaxAngleTruckBed());
    }

    /**
     * gets a true or false statement if the ramp is open or not.
     * @return state of the ramp.
     */
    public boolean isRampOpen(){
        return truck.getTruckBedAngle() == truck.getMaxAngleTruckBed();
    }

    /**
     * calculates the distance to the car that will get loaded to the car transport
     * @param vehicle
     * @return distance from car to the vehicle.
     */
    private double getDistance(V vehicle){
        double xDiff = this.getxPosition()-vehicle.getxPosition();
        double yDiff = this.getyPosition()-vehicle.getyPosition();
        return Math.sqrt(xDiff*xDiff+yDiff*yDiff);
    }

    /**
     * checks if the car is close enought to the car transport
     * @param vehicle
     * @return if car is close enought.
     */
    private boolean vehicleCloseEnough(V vehicle){
        double absDistance = getDistance(vehicle);
        return absDistance <= proximityThreshold;
    }

    /**
     * loads the car into the car transport. Checks if ramp is open, if cargo is close enough and weight limit of the car.
     * @param vehicle
     */
    // TODO gör om detta lite om vi har tid
    public void load(V vehicle) {
        if(isRampOpen()){
            if(vehicleCloseEnough(vehicle)){
                if(vehicle.getWeight() < cargoWeightLimit){
                    cargo.load(vehicle);
                    synchronizeCargo();
                }
                else{
                    System.out.println("The vehicle is too large to load.");
                }
            }
            else{
                System.out.println("The vehicle must be closer in order to load it.");
            }
        }
        else{
            System.out.println("Ramp must be down in order to load the car.");
        }
    }

    /**
     * unloads the car from the car transport. Checks if we have any cars loaded first.
     * @return unloaded car or null if list is empty.
     */
    // TODO if list is empty it returns null
    public V unload(){
        V vehicle = cargo.unload();
        try {
            vehicle.setxPosition(truck.getxPosition()-0.1);
            vehicle.setyPosition(truck.getyPosition()-0.1);
        } catch (NullPointerException e){
        }

        return vehicle;
    }
}

