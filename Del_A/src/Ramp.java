/**
 * Class that handles a ramp for a vehicle
 */
public class Ramp {

    private int truckBedAngle;
    private int maxAngleTruckBed;
    private int minAngleTruckBed;

    public Ramp(){
        maxAngleTruckBed = 45;
        minAngleTruckBed = 0;
        truckBedAngle = 0;
    }

    public Ramp(int maxAngleTruckBed, int minAngleTruckBed){
        this.truckBedAngle = minAngleTruckBed;
        this.maxAngleTruckBed = maxAngleTruckBed;
        this.minAngleTruckBed = minAngleTruckBed;
    }

    public int getTruckBedAngle() {return truckBedAngle;}

    private void setTruckBedAngle(int newAngle) {truckBedAngle = newAngle;}

    public int getMaxAngleTruckBed() { return maxAngleTruckBed;}

    public int getMinAngleTruckBed() { return minAngleTruckBed;}

    public void increaseTruckBedAngle(int amount, double currentSpeed){
        if (currentSpeed == 0.0) {
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

}
