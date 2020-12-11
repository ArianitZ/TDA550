import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
/**
 *  A class that shows the speed of the vehicles contained in CarModel as a JLabel.
 *
 * @author Arianit Zeqiri, Jakob Stråhle, Veronica Segerlind
 * @version 1.0
 */
public class SpeedPanel extends JPanel {

    private List<JLabel> labelList;
    private final CarModel carModel;
    private int numberOfCars;


    public SpeedPanel(CarModel carModel){
        this.carModel = carModel;
        this.numberOfCars = carModel.getNumberOfCars();
        this.labelList = new ArrayList<>();

        initializeComponents();
    }


    private void initializeComponents(){
        for (Vehicle car : carModel){
            String carName = car.getModelName();
            double carSpeed = car.getCurrentSpeed();

            String labelString = carName + ": " + carSpeed;

            labelList.add(new JLabel(labelString));
        }

        initializePanel();
    }


    private void initializePanel(){
        for(JLabel label : labelList){
            this.add(label);
        }
    }


    private void synchronizeLabelList(){
        labelList = new ArrayList<>();
        this.removeAll();
        initializeComponents();
        this.numberOfCars = carModel.getNumberOfCars();
    }


    public void updateSpeed(){

        if(numberOfCars != carModel.getNumberOfCars()){
            synchronizeLabelList();
        }

        int ix = 0;
        for(Vehicle car: carModel){
            String carName = car.getModelName();
            double carSpeed = car.getCurrentSpeed();

            String labelString = carName + ": " + carSpeed;

            labelList.get(ix).setText(labelString);
            ix++;
        }
        this.repaint();
        this.doLayout();
    }
}
