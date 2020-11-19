import java.awt.*;
import java.util.List;
import java.util.Stack;

public class CarFerry<C extends Vehicle> implements SeaBasedVehicle{

    private Loader<C> loader;
    private Stack<C> cargo;
    private int maxCapacity;
    private Vehicle seaBasedVehicle;
    private Ramp ramp;
    private double proximityThreshold;
    private double cargoWeightLimit;

    public CarFerry(){
        seaBasedVehicle = new Vehicle(2,1000, 0.0, Color.white, "Båten", 90,
                                      0.0, 0.0, 20000);
        cargo = new Stack<>();
        maxCapacity = 30;
        loader = new Loader<>(cargo, maxCapacity);
        ramp = new Ramp(90, 0);
        proximityThreshold = 0.1;
        cargoWeightLimit = 3000;
    }
    public int getNrDoors(){
        return seaBasedVehicle.getNrDoors();
    }
    public double getEnginePower(){
        return seaBasedVehicle.getEnginePower();
    }
    public double getCurrentSpeed(){
        return seaBasedVehicle.getCurrentSpeed();
    }
    public Color getColor(){
        return seaBasedVehicle.getColor();
    }
    public void setColor(Color clr){ seaBasedVehicle.setColor(clr); }
    public double getWeight(){ return seaBasedVehicle.getWeight();}
    public double speedFactor(){return seaBasedVehicle.speedFactor();}
    public void stopEngine(){
        seaBasedVehicle.stopEngine();
    }
    public void gas(double amount){ seaBasedVehicle.gas(amount); }
    public void brake(double amount){ seaBasedVehicle.brake(amount);}
    public int getDirection(){return seaBasedVehicle.getDirection();}
    public double getxPosition(){return seaBasedVehicle.getxPosition();}
    public double getyPosition(){return seaBasedVehicle.getyPosition();}

    public void startEngine() {
        if (ramp.getTruckBedAngle() > ramp.getMinAngleTruckBed()) {
            System.out.println("You can't start the engine while having the ramp open");
        }
        else{
            seaBasedVehicle.startEngine();
        }
    }

    public void openRamp(){
        ramp.increaseTruckBedAngle(ramp.getMaxAngleTruckBed(), seaBasedVehicle.getCurrentSpeed());
    }

    public void closeRamp(){
        ramp.decreaseTruckBedAngle(ramp.getMaxAngleTruckBed());
    }

    public boolean isRampOpen(){
        return ramp.getTruckBedAngle() == ramp.getMaxAngleTruckBed();
    }
    public int getCurrentLoadQuantity(){
        return cargo.size();
    }

    public int getMaxCapacity(){
        return maxCapacity;
    }

    public void turnLeft(){
        seaBasedVehicle.turnLeft();
        synchronizeCargo();
    }
    public void turnRight(){
        seaBasedVehicle.turnRight();
        synchronizeCargo();
    }

    public void move(){
        seaBasedVehicle.move();
        synchronizeCargo();
    }

    private void synchronizeCargo(){
        loader.synchronizeCargo(seaBasedVehicle);
    }
    private double getDistance(C vehicle){
        double xDiff = this.getxPosition()-vehicle.getxPosition();
        double yDiff = this.getyPosition()-vehicle.getyPosition();

        return Math.sqrt(xDiff*xDiff+yDiff*yDiff);
    }

    private boolean vehicleCloseEnough(C vehicle){
        double absDistance = getDistance(vehicle);
        return absDistance <= proximityThreshold;
    }

    public void load(C vehicle) {
        if(isRampOpen()){
            if(vehicleCloseEnough(vehicle)){
                if(vehicle.getWeight() < cargoWeightLimit){
                    loader.load(vehicle);
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

    public C unload(){
        C vehicle = cargo.pop();
        try {
            vehicle.setxPosition(seaBasedVehicle.getxPosition()-0.1);
            vehicle.setyPosition(seaBasedVehicle.getyPosition()-0.1);
        } catch (NullPointerException e){
            System.out.println("Nothing to unload");
        }
        return vehicle;
    }



}
