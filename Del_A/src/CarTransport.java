import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class CarTransport{

    private Truck truck;
    private Loader<Vehicle, Truck> cargo;
    private ArrayList<Vehicle> listOfVehicles;
    private int maxCapacity;
    private double proximityThreshold;
    //private boolean rampOpen;

    // TODO change min/max truck bed angle
    public CarTransport(){
        truck = new Truck(2, 100.0, 0.0, Color.blue, "Truck", 90, 0.0, 0.0,
                          10000.0, 0, 45);
        listOfVehicles = new ArrayList<Vehicle>();
        maxCapacity = 10;
        cargo = new Loader<Vehicle, Truck>(listOfVehicles, maxCapacity);
        proximityThreshold = 0.1;
    }

    public CarTransport(int nrDoors, double enginePower, double currentSpeed,
                        Color color, String modelName, int direction,
                        double xPosition, double yPosition, double weight,
                        int minAngle, int maxAngle, int maxCapacity){
        truck = new Truck(nrDoors, enginePower, currentSpeed, color, modelName, direction,
                          xPosition, yPosition, weight, minAngle, maxAngle);
        listOfVehicles = new ArrayList<>();
        this.maxCapacity = maxCapacity;
        cargo = new Loader<Vehicle, Truck>(listOfVehicles, this.maxCapacity);
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

    // TODO vi ska även anropa bilarna/lasten när vi använder oss av move/turnleft
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
        for(Vehicle vehicle : listOfVehicles){
            vehicle.setxPosition(truck.getxPosition());
            vehicle.setyPosition(truck.getyPosition());
            vehicle.setDirection(truck.getDirection());
        }
    }
    // TODO add conditions
    public void openRamp(){
        if(truck.getCurrentSpeed() == 0.0){
            truck.increaseTruckBedAngle(truck.getMaxAngleTruckBed());
        }
        else{
            System.out.println("You cant open the ramp while driving.");
        }
    }

    // TODO add conditions
    public void closeRamp(){
        truck.decreaseTruckBedAngle(truck.getMaxAngleTruckBed());
    }

    public boolean isRampOpen(){
        return truck.getTruckBedAngle() == truck.getMaxAngleTruckBed();
    }

    private double getDistance(Vehicle vehicle){
        double xDiff = this.getxPosition()-vehicle.getxPosition();
        double yDiff = this.getyPosition()-vehicle.getyPosition();

        return Math.sqrt(xDiff*xDiff+yDiff*yDiff);
    }

    private boolean vehicleCloseEnough(Vehicle vehicle){
        double absDistance = getDistance(vehicle);
        return absDistance < proximityThreshold;
    }


    // TODO
    public void load(Vehicle vehicle) {
        if(isRampOpen()){
            if(vehicleCloseEnough(vehicle)){
                cargo.load(vehicle, truck);
            }
            else{
                System.out.println("The vehicle must be closer in order to load it.");
            }
        }
        else{
            System.out.println("Ramp must be down in order to load the car.");
        }

    }

    // TODO
    public void unload(){

    }

    public static void main(String [] args){
        CarTransport transporter = new CarTransport();
        Saab95 saab = new Saab95();
        saab.startEngine();
        transporter.startEngine();

        for(int i = 0; i < 10; i++){
            transporter.move();
            saab.move();
        }
        saab.move();
        saab.turnLeft();
        transporter.stopEngine();
        transporter.openRamp();

        System.out.println("---------------Before loading-----------------");
        System.out.println(saab.getyPosition());
        System.out.println(saab.getDirection());
        System.out.println(transporter.getyPosition());

        transporter.load(saab);

        System.out.println("---------------After loading-----------------");
        System.out.println(saab.getyPosition());
        System.out.println(saab.getDirection());
        System.out.println(transporter.getyPosition());
        System.out.println(transporter.getDirection());
        transporter.closeRamp();
        transporter.startEngine();
        for(int i = 0; i < 10; i++){
            transporter.move();
            if(i%3 == 0){
                transporter.turnRight();
            }
            System.out.printf("Saab: (%f, %f)\t Transporter: (%f, %f)\n",saab.getxPosition(),
                               saab.getyPosition(), transporter.getxPosition(), transporter.getyPosition());
        }
        System.out.println(transporter.getCurrentSpeed());
        transporter.openRamp();

    }

    public void setxPosition(double newxPosition) {
        truck.setxPosition(newxPosition);
    }

    public void setyPosition(double newyPosition) {
        truck.setyPosition(newyPosition);
    }
}

