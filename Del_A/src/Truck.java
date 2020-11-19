import java.awt.*;

public class Truck extends Vehicle{

    private Ramp truckBed;

    // TODO change engine power
    public Truck(int nrDoors, double enginePower, double currentSpeed,
                 Color color, String modelName, int direction,
                 double xPosition, double yPosition, double weight,
                 int minAngleTruckBed, int maxAngleTruckBed){
        super(nrDoors, enginePower, currentSpeed, color, modelName, direction,
                xPosition, yPosition, weight);
        truckBed = new Ramp(maxAngleTruckBed, minAngleTruckBed);
    }

    // TODO change this so that cars are not slower than trucks
    @Override
    public double speedFactor(){
        return getEnginePower()*0.01;
    }

    public int getTruckBedAngle() {return truckBed.getTruckBedAngle();}

    public int getMaxAngleTruckBed() { return truckBed.getMaxAngleTruckBed();}

    public int getMinAngleTruckBed() { return truckBed.getMinAngleTruckBed();}

    public void increaseTruckBedAngle(int amount){
        truckBed.increaseTruckBedAngle(amount, this.getCurrentSpeed());
    }
    
    public void decreaseTruckBedAngle(int amount){
        truckBed.decreaseTruckBedAngle(amount);
    }

    @Override
    public void startEngine(){
        if(truckBed.getTruckBedAngle() > truckBed.getMinAngleTruckBed()){
            System.out.println("You can't drive while having the truck bed raised");
        }
        else{ super.startEngine(); }
    }

    @Override
    public void move(){
        if(truckBed.getTruckBedAngle() > truckBed.getMinAngleTruckBed()){
            System.out.println("You can't drive while having the truck bed raised");
        }
        else{
            super.move();
        }
    }

}
