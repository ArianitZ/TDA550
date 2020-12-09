import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CarController{
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 20;

    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    Updateable frame;
    CarModel cars;


    public CarController(CarModel model){
        this.cars = model;
    }


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
        for(Vehicle car: cars) {
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

    public void lowerBedButton(){
        for(Vehicle car: cars){
            if (car instanceof Truck) {
                ((Truck)car).decreaseTruckBedAngle(30);
            }
        }
    }

    private void checkBoundaryConditions(Vehicle car){
        Point sizeOfFrame = frame.getViewDimensions();
        Point sizeOfImage = getImageSize(car);

        boolean xMaxCondition = car.getxPosition() > sizeOfFrame.y - sizeOfImage.y;
        boolean xMinCondition = car.getxPosition() < 0;

        boolean yMaxCondition = car.getyPosition() > sizeOfFrame.x - sizeOfImage.x;
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

}
