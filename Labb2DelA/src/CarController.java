import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController{
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        Saab95 saab = new Saab95(2, 125.0, 0.0, Color.red, "Saab95", 0, 0.0, 0.0, 2000);
        saab.setyPosition(100.0);

        Scania scania = new Scania(2, 100.0, 0.0, Color.blue, "Scania", 0, 0.0, 0.0, 10000, 0, 70);
        scania.setyPosition(200.0);



        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();

        cc.cars.add(new Volvo240(4, 100.0, 0.0, Color.black, "Volvo240", 0, 0.0, 0.0, 1500));
        cc.cars.add(scania);
        cc.cars.add(saab);
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                checkBoundaryConditions(car);
                car.move();
                frame.drawPanel.moveit(car);
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount){
        double brake = ((double) amount) / 100;

        for(Vehicle car: cars){
            car.brake(brake);
        }
    }
//nytt
    void startEngine(){
        for(Vehicle car : cars){
            car.startEngine();
        }
    }

    void stopEngine(){
        for(Vehicle car: cars){
            car.stopEngine();
        }
    }

    void turboOnButton(){
        for(Vehicle car: cars){
            if (car instanceof Saab95) {
                //System.out.println(((Saab95)car).getTurboOn());
                ((Saab95)car).setTurboOn();
                //System.out.println(((Saab95)car).getTurboOn());
            }
        }
    }

    void turboOffButton(){
        for(Vehicle car: cars){
            if (car instanceof Saab95) {
                ((Saab95)car).setTurboOff();
            }
        }
    }

    void liftBedButton(){
        for(Vehicle car: cars){
            if (car instanceof Truck) {
                ((Scania)car).increaseTruckBedAngle(30);
            }
        }
    }

    void lowerBedButton(){
        for(Vehicle car: cars){
            if (car instanceof Truck) {
                ((Scania)car).decreaseTruckBedAngle(30);
            }
        }
    }

    void checkBoundaryConditions(Vehicle car){
        Dimension size = frame.drawPanel.getSize();


        boolean xMaxCondition = car.getxPosition() > size.width;
        boolean xMinCondition = car.getxPosition() < 0;

        boolean yMaxCondition = car.getyPosition() > size.height;
        boolean yMinCondition = car.getyPosition() < 0;

        if(xMaxCondition || xMinCondition || yMaxCondition || yMinCondition ){
            changeVehicleDirection(car);
        }
    }

    void changeVehicleDirection(Vehicle car){
        car.turnLeft();
        car.turnLeft();
    }

}
