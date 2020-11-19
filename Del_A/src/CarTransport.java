import java.awt.*;
import java.util.ArrayList;

public class CarTransport<V extends Vehicle>{

    // TODO ändra namnet på Loader<V> cargo till Loader<V> loader
    private final Truck truck;
    private final Loader<V> cargo;
    private final ArrayList<V> listOfVehicles;
    private final int maxCapacity;
    private final double cargoWeightLimit;
    private double proximityThreshold;

    public CarTransport(){
        truck = new Truck(2, 100.0, 0.0, Color.blue, "Truck", 90, 0.0, 0.0,
                          10000.0, 0, 45);
        listOfVehicles = new ArrayList<>();
        maxCapacity = 10;
        cargo = new Loader<>(listOfVehicles, maxCapacity);
        proximityThreshold = 0.1;
        cargoWeightLimit = 3000;
    }

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

    public int getNrDoors(){
        return truck.getNrDoors();
    }
    public double getEnginePower(){
        return truck.getEnginePower();
    }
    public double getCurrentSpeed(){
        return truck.getCurrentSpeed();
    }
    public Color getColor(){
        return truck.getColor();
    }
    public void setColor(Color clr){ truck.setColor(clr); }
    public double getWeight(){ return truck.getWeight();}
    public void startEngine(){ truck.startEngine(); }
    public double speedFactor(){return getEnginePower()*0.01;}
    public void stopEngine(){
        truck.stopEngine();
    }
    public void gas(double amount){ truck.gas(amount); }
    public void brake(double amount){ truck.brake(amount);}
    public int getDirection(){return truck.getDirection();}
    public double getxPosition(){return truck.getxPosition();}
    public double getyPosition(){return truck.getyPosition();}

    public int getCurrentLoadQuantity(){
        return listOfVehicles.size();
    }

    public int getMaxCapacity(){
        return maxCapacity;
    }

    public void turnLeft(){
        truck.turnLeft();
        synchronizeCargo();
    }
    public void turnRight(){
        truck.turnRight();
        synchronizeCargo();
    }

    public void move(){
        truck.move();
        synchronizeCargo();

    }

    private void synchronizeCargo(){
        cargo.synchronizeCargo(truck);
    }

    public void openRamp(){
        if(truck.getCurrentSpeed() == 0.0){
            truck.increaseTruckBedAngle(truck.getMaxAngleTruckBed());
        }
        else{
            System.out.println("You cant open the ramp while driving.");
        }
    }

    public void closeRamp(){
        truck.decreaseTruckBedAngle(truck.getMaxAngleTruckBed());
    }

    public boolean isRampOpen(){
        return truck.getTruckBedAngle() == truck.getMaxAngleTruckBed();
    }

    private double getDistance(V vehicle){
        double xDiff = this.getxPosition()-vehicle.getxPosition();
        double yDiff = this.getyPosition()-vehicle.getyPosition();

        return Math.sqrt(xDiff*xDiff+yDiff*yDiff);
    }

    private boolean vehicleCloseEnough(V vehicle){
        double absDistance = getDistance(vehicle);
        return absDistance <= proximityThreshold;
    }

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

