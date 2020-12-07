import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CarApplication {
    private final int delay = 50;
//    private Timer timer = new Timer(delay, new TimerListener());
//
//    private static CarController cc;
//    private static CarView frame;

    public static void main(String[] args){


        Vehicle volvo = CarFactory.createVolvo240(0.0, 0.0);
        Vehicle saab = CarFactory.createSaab95(0.0, 100.0);
        Vehicle scania = CarFactory.createScania(0.0, 200.0);

        CarModel model = new CarModel();
        model.addCar(volvo);
        model.addCar(saab);
        model.addCar(scania);

        CarController cc = new CarController(model);
        CarView frame = new CarView("CarSim 1.0", cc);
        cc.frame = frame.drawPanel;
        cc.startTimer();

        //cc =  new CarController(model);
        //frame = new CarView("CarSim 1.0", cc);
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
//    private class TimerListener implements ActionListener {
//
//        public void actionPerformed(ActionEvent e) {
//
//            for (Vehicle car : cars) {
//
//                cc.checkBoundaryConditions(car, frame.drawPanel.getSize());
//                car.move();
//                frame.drawPanel.moveit(car);
//            }
//            frame.drawPanel.repaint();
//        }
//    }

}
