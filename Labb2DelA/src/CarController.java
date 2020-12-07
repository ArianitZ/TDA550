import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    Updateable frame;
    CarModel cars;

    public CarController(CarModel model){
        this.cars = model;
    }

    //methods:
    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            for (Vehicle car : cars) {
                checkBoundaryConditions(car);
                car.move();
                frame.move(car);
            }
            frame.paint();
        }
    }

    public void startTimer(){
        this.timer.start();
    }

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
                ((Saab95)car).setTurboOn();
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
                ((Truck)car).increaseTruckBedAngle(30);
            }
        }
    }

    void lowerBedButton(){
        for(Vehicle car: cars){
            if (car instanceof Truck) {
                ((Truck)car).decreaseTruckBedAngle(30);
            }
        }
    }

    void checkBoundaryConditions(Vehicle car){
    //void checkBoundaryConditions(Vehicle car, Dimension size){
//        Dimension size = frame.drawPanel.getSize();
//
//        String S = "pics/"+car.getModelName()+".jpg";
//        BufferedImage IM = null;
//        try {
//            IM = ImageIO.read(CarController.class.getResourceAsStream(S));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        int width          = IM.getWidth();
//        int height         = IM.getHeight();

        int width = 0;
        int height = 0;
        Dimension size = new Dimension(800,800-240);

        boolean xMaxCondition = car.getxPosition() > size.width- width;
        boolean xMinCondition = car.getxPosition() < 0;

        boolean yMaxCondition = car.getyPosition() > size.height- height;
        boolean yMinCondition = car.getyPosition() < 0;

        if(xMaxCondition || xMinCondition || yMaxCondition || yMinCondition ) {
            changeVehicleDirection(car);
        }
    }


    void changeVehicleDirection(Vehicle car){
        car.turnLeft();
        car.turnLeft();
    }

}
