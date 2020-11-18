import java.awt.*;
public class Scania extends Truck {

    public Scania(){
        super(2, 100.0, 0.0, Color.blue, "Scania", 90, 0.0, 0.0, 10000, 0, 70);
    }
    // TODO change engine power
    public Scania(int nrDoors, double enginePower, double currentSpeed,
                 Color color, String modelName, int direction,
                 double xPosition, double yPosition, double weight,
                 int minAngleTruckBed, int maxAngleTruckBed){
        super(nrDoors, enginePower, currentSpeed, color, modelName, direction,
                xPosition, yPosition, weight, minAngleTruckBed, maxAngleTruckBed);
    }

}
