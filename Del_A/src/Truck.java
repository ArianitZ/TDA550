import java.awt.*;

public abstract class Truck extends Car{

    private int truckBedAngle;
    private int maxAngleTruckBed;
    private int minAngleTruckBed;

    // TODO change engine power
    public Truck(int nrDoors, double enginePower, double currentSpeed,
                 Color color, String modelName, int direction,
                 double xPosition, double yPosition, int minAngleTruckBed,
                 int maxAngleTruckBed){
        super(nrDoors, enginePower, currentSpeed, color, modelName, direction,
                xPosition, yPosition);
        truckBedAngle = 0;
        this.maxAngleTruckBed = maxAngleTruckBed;
        this.minAngleTruckBed = minAngleTruckBed;
    }

    public int getTruckBedAngle() {return truckBedAngle;}

    public void setTruckBedAngle(int newAngle) {truckBedAngle = newAngle;}

    // TODO change this so that cars are not slower than trucks
    public double speedFactor(){
        return getEnginePower()*0.01;
    }

    public int getMaxAngleTruckBed() { return maxAngleTruckBed;}

    public int getMinAngleTruckBed() { return minAngleTruckBed;}

    public void increaseTruckBedAngle(int amount){
        if (getCurrentSpeed() == 0.0) {
            int newAngle = getTruckBedAngle() + amount;
            newAngle = (newAngle < maxAngleTruckBed) ? newAngle : maxAngleTruckBed;
            setTruckBedAngle(newAngle);
        }
        else{
            System.out.println("You can't increase the truck bed angle while moving!");
        }
    }

    public void decreaseTruckBedAngle(int amount){
        int newAngle = getTruckBedAngle() - amount;
        newAngle = (newAngle > minAngleTruckBed) ? newAngle: minAngleTruckBed;
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

}
