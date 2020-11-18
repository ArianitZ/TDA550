import java.awt.*;
import java.util.ArrayList;

public class CarTransport{

    private Truck truck;
    private Loader<Vehicle> cargo;
    private ArrayList<Vehicle> listOfVehicles;
    private int maxCapacity;
    private boolean rampOpen;

    // TODO change min/max truck bed angle
    public CarTransport(){
        truck = new Truck(2, 100.0, 0.0, Color.blue, "Truck", 90, 0.0, 0.0,
                          10000.0, 0, 45);
        listOfVehicles = new ArrayList<Vehicle>();
        maxCapacity = 10;
        cargo = new Loader<Vehicle>(listOfVehicles, maxCapacity);
        rampOpen = false;
    }

    public CarTransport(int nrDoors, double enginePower, double currentSpeed,
                        Color color, String modelName, int direction,
                        double xPosition, double yPosition, double weight,
                        int minAngle, int maxAngle, int maxCapacity){
        truck = new Truck(nrDoors, enginePower, currentSpeed, color, modelName, direction,
                          xPosition, yPosition, weight, minAngle, maxAngle);
        listOfVehicles = new ArrayList<>();
        this.maxCapacity = maxCapacity;
        cargo = new Loader<Vehicle>(listOfVehicles, this.maxCapacity);
        rampOpen = false;
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
    // TODO ska vi returnera lastbilens nuvarande vikt (dvs vikten på lastbilen + alla bilar)
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
    public void turnLeft(){truck.turnLeft();}
    public void turnRight(){truck.turnRight();}
    public void move(){truck.move();}

    // TODO add conditions
    public void openRamp(){
        truck.increaseTruckBedAngle(truck.getMaxAngleTruckBed());
        rampOpen = true;
    }
    // TODO add conditions
    public void closeRamp(){
        truck.decreaseTruckBedAngle(truck.getMinAngleTruckBed());
        rampOpen = false;
    }

    // TODO
    public void load(Vehicle vehicle) {
        if(rampOpen){
        }
    }

    // TODO
    public void unload(){

    }

}

