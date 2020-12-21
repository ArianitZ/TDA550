import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *  A class that controls the buttons of the CarView as well as the animated part of an.
 *
 * @author Arianit Zeqiri, Jakob Stråhle, Veronica Segerlind
 * @version 1.0
 */
public class CarController implements ViewObserver{
    private final int delay = 20;

    private final Timer timer = new Timer(delay, new TimerListener());

    private final CarModel carModel;


    public CarController(CarModel model){
        this.carModel = model;
    }


    @Override
    public void actOnStartEngine() {
        carModel.startEngine();
    }


    @Override
    public void actOnStopEngine() {
        carModel.stopEngine();
    }


    @Override
    public void actOnChangeInGas(int gasAmount) {
        carModel.gas(gasAmount);
    }


    @Override
    public void actOnChangeInBrake(int gasAmount) {
        carModel.brake(gasAmount);
    }


    @Override
    public void actOnTurboOn() {
        carModel.turboOn();
    }


    @Override
    public void actOnTurboOff() {
        carModel.turboOff();
    }


    @Override
    public void actOnLiftBed() {
        carModel.liftBed();
    }


    @Override
    public void actOnLowerBed() {
        carModel.lowerBed();
    }


    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            carModel.moveCars();
        }
    }


    public void startTimer(){
        this.timer.start();
    }
}
