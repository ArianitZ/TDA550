import java.awt.*;
import java.util.ArrayList;

public class CarTransport extends Car{

    private Loader<Car> cargo;
    private ArrayList<Car> listOfCars;
    private int maxCapacity;
    private boolean rampOpen;


    // TODO change min/max truck bed angle
    public CarTransport(){
        super(2, 100.0, 0.0, Color.blue, "transporter",
              90,0.0, 0.0, 10000);
        listOfCars = new ArrayList<>();
        maxCapacity = 5;
        cargo = new Loader<Car>(listOfCars, maxCapacity);
        rampOpen = false;
    }

    public CarTransport(int nrDoors, double enginePower, double currentSpeed,
                        Color color, String modelName, int direction,
                        double xPosition, double yPosition, double weight,
                        int maxCapacity){
        super(nrDoors, enginePower, currentSpeed, color, modelName, direction,
              xPosition, yPosition, weight);
        listOfCars = new ArrayList<>();
        cargo = new Loader<Car>(listOfCars, maxCapacity);
        rampOpen = false;
    }

    // TODO
    public void load(Car car) {

    }
    // TODO
    public void unload(){

    }

    // TODO add conditions
    public void openRamp(){
        rampOpen = true;
    }

    // TODO add conditions
    public void closeRamp(){
        rampOpen = false;
    }

    @Override
    public double speedFactor(){
        return getEnginePower()*0.01;
    }

}
