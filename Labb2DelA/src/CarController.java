import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
/**
 *  A class that controls the buttons of the CarView as well as the animated part of an UpdateablePanel object.
 *
 * @author Arianit Zeqiri, Jakob Stråhle, Veronica Segerlind
 * @version 1.0
 */
public class CarController{
    private final int delay = 50;

    private Timer timer = new Timer(delay, new TimerListener());

    protected UpdateablePanel frame;
    private CarModel cars;


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


    protected void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }


    protected void brake(int amount){
        double brake = ((double) amount) / 100;
        for(Vehicle car: cars) {
            car.brake(brake);
        }
    }


    protected void startEngine(){
        for(Vehicle car : cars){
            car.startEngine();
        }
    }


    protected void stopEngine(){
        for(Vehicle car: cars){
            car.stopEngine();
        }
    }


    protected void turboOnButton(){
        for(Vehicle car: cars){
            if (car instanceof Saab95) {
                ((Saab95)car).setTurboOn();
            }
        }
    }


    protected void turboOffButton(){
        for(Vehicle car: cars){
            if (car instanceof Saab95) {
                ((Saab95)car).setTurboOff();
            }
        }
    }


    protected void liftBedButton(){
        for(Vehicle car: cars){
            if (car instanceof Truck) {
                ((Truck)car).increaseTruckBedAngle(30);
            }
        }
    }


    protected void lowerBedButton(){
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
