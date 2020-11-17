import java.awt.*;
import java.util.ArrayList;

public class CarsTransport extends Truck{

    private Loader<Car> cargo;
    private ArrayList<Car> listOfCars;

    // TODO change min/max truck bed angle
    public CarsTransport(){
        super(2, 100.0, 0.0, Color.blue, "transporter",
              90,0.0, 0.0, 0, 70);
    }

    public CarsTransport(int nrDoors, double enginePower, double currentSpeed,
                         Color color, String modelName, int direction,
                         double xPosition, double yPosition, int minAngleTruckBed,
                         int maxAngleTruckBed){
        super(nrDoors, enginePower, currentSpeed, color, modelName, direction,
              xPosition, yPosition, minAngleTruckBed, maxAngleTruckBed);
    }

    public void load(){
        cargo.load(listOfCars, new Saab95());
    }

    public void unload(){

    }

    public void main (String[] args){
        CarsTransport lastbil = new CarsTransport();
     }
}
