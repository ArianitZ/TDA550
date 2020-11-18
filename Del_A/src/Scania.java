import java.awt.*;
// Polymorphism needed - Yes
// Code reuse - Yes
// Is-A car - Yes?
// Roles - No, a truck is always a truck and a Saab95 is always a Saab95


//2, 100.0, 0.0, Color.blue, "Scania", 90, 0.0, 0.0, 0, 70)
public class Scania extends Car{

    private int truckBedAngle;
    private final int maxAngleTruckBed;
    private final int minAngleTruckBed;

    public Scania(){
        super(2, 100.0, 0.0, Color.blue, "Scania", 90, 0.0, 0.0, 10000);
        maxAngleTruckBed = 70;
        minAngleTruckBed = 0;
    }
    // TODO change engine power
    public Scania(int nrDoors, double enginePower, double currentSpeed,
                 Color color, String modelName, int direction,
                 double xPosition, double weight, double yPosition,
                 int minAngleTruckBed, int maxAngleTruckBed){
        super(nrDoors, enginePower, currentSpeed, color, modelName, direction,
                xPosition, yPosition, weight);
        truckBedAngle = 0;
        this.maxAngleTruckBed = maxAngleTruckBed;
        this.minAngleTruckBed = minAngleTruckBed;
    }

    public int getTruckBedAngle() {return truckBedAngle;}

    private void setTruckBedAngle(int newAngle) {truckBedAngle = newAngle;}

    // TODO change this so that cars are not slower than trucks
    public double speedFactor(){
        return getEnginePower()*0.01;
    }

    public int getMaxAngleTruckBed() { return maxAngleTruckBed;}

    public int getMinAngleTruckBed() { return minAngleTruckBed;}

    public void increaseTruckBedAngle(int amount){
        if (getCurrentSpeed() == 0.0) {
            int newAngle = getTruckBedAngle() + amount;
            newAngle = (newAngle < getMaxAngleTruckBed()) ? newAngle : getMaxAngleTruckBed();
            setTruckBedAngle(newAngle);
        }
        else{
            System.out.println("You can't increase the truck bed angle while moving!");
        }
    }

    public void decreaseTruckBedAngle(int amount){
        int newAngle = getTruckBedAngle() - amount;
        newAngle = (newAngle > getMinAngleTruckBed()) ? newAngle: getMinAngleTruckBed();
        setTruckBedAngle(newAngle);
    }

    @Override
    public void move(){
        if(truckBedAngle > minAngleTruckBed){
            System.out.println("You can't drive while having the truck bed raised");
        }
        else{
            super.move();
        }
    }

    public static void main(String[] args){
        Scania scania = new Scania();
        scania.move();
    }

}
