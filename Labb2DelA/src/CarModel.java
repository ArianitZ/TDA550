import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
/**
 *  A class that acts as the model part of an application that uses the MVC desgin pattern.
 *  Stores vehicles and can return an iterator of the stored vehicles.
 *
 * @author Arianit Zeqiri, Jakob Stråhle, Veronica Segerlind
 * @version 1.0
 */
public class CarModel implements Iterable<Vehicle> {

    private final List<Vehicle> cars;
    private final List<Observer> observers;

    private int numberOfCars;
    private final int maxNumberOfCars;

    private final int xDimension;
    private final int yDimension;


    public CarModel(int xDim, int yDim, int maxNumberOfCars){
        this.xDimension = xDim;
        this.yDimension = yDim;

        this.maxNumberOfCars = maxNumberOfCars;

        cars = new Stack<>();
        observers = new ArrayList<>();
    }


    public int getNumberOfCars(){
        return numberOfCars;
    }


    @Override
    public Iterator<Vehicle> iterator() {
        return this.cars.iterator();
    }


    protected void addCar(){
        if(numberOfCars < maxNumberOfCars){
            double xPosition = 0.0;
            double yPosition = numberOfCars*70.0;

            this.addCar(CarFactory.createRandomVehicle(xPosition, yPosition));
        }
    }


    protected void addCar(Vehicle car) {
        if (numberOfCars < maxNumberOfCars) {
            this.cars.add(car);
            numberOfCars++;
            notifyChangeInNumberOfCars();
        }
    }


    protected void removeCar(){
        if(numberOfCars > 0) {
            ((Stack<Vehicle>) this.cars).pop();
            numberOfCars--;
            notifyChangeInNumberOfCars();
        }
    }


    protected void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
        notifyChangedSpeed();
    }


    protected void brake(int amount){
        double brake = ((double) amount) / 100;
        for(Vehicle car: cars) {
            car.brake(brake);
        }
        notifyChangedSpeed();
    }


    protected void startEngine(){
        for(Vehicle car : cars){
            car.startEngine();
        }
        notifyChangedSpeed();
    }


    protected void stopEngine(){
        for(Vehicle car: cars){
            car.stopEngine();
        }
        notifyChangedSpeed();
    }


    protected void turboOn(){
        for(Vehicle car: cars){
            if (car instanceof Saab95) {
                ((Saab95)car).setTurboOn();
            }
        }
    }


    protected void turboOff(){
        for(Vehicle car: cars){
            if (car instanceof Saab95) {
                ((Saab95)car).setTurboOff();
            }
        }
    }


    protected void liftBed(){
        for(Vehicle car: cars){
            if (car instanceof Truck) {
                ((Truck)car).increaseTruckBedAngle(30);
            }
        }
    }


    protected void lowerBed(){
        for(Vehicle car: cars){
            if (car instanceof Truck) {
                ((Truck)car).decreaseTruckBedAngle(30);
            }
        }
    }


    protected void moveCars(){
        for (Vehicle car : cars) {
            checkBoundaryConditions(car);
            car.move();
        }
        notifyChangedPosition();

    }


    private void checkBoundaryConditions(Vehicle car){
        Point sizeOfImage = getImageSize(car);

        boolean xMaxCondition = car.getxPosition() > xDimension - sizeOfImage.y;
        boolean xMinCondition = car.getxPosition() < 0;

        boolean yMaxCondition = car.getyPosition() > yDimension - sizeOfImage.x;
        boolean yMinCondition = car.getyPosition() < 0;

        if(xMaxCondition || xMinCondition || yMaxCondition || yMinCondition ) {
            changeVehicleDirection(car);
        }
    }


    private Point getImageSize(Vehicle car){
        String S = "pics/"+car.getModelName()+".jpg";
        BufferedImage IM = null;

        try {
            IM = ImageIO.read(CarController.class.getResourceAsStream(S));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int width          = IM.getWidth();
        int height         = IM.getHeight();

        return new Point(height,width);
    }


    private void changeVehicleDirection(Vehicle car){
        car.turnLeft();
        car.turnLeft();
    }


    public void addObserver(Observer observer){
        this.observers.add(observer);
    }


    private void notifyChangedSpeed(){
        for(Observer observer : observers){
            observer.actOnSpeedChange(this.iterator());
        }
    }


    private void notifyChangedPosition(){
        for(Observer observer: observers){
            observer.actOnPositionChange(this.iterator());
        }
    }


    private void notifyChangeInNumberOfCars(){
        for(Observer observer: observers){
            observer.actOnNumberOfCarsChange(this.iterator());
        }
    }
}
