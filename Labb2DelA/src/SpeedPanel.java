import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SpeedPanel extends JPanel {

    private List<JLabel> labelList;
    private CarModel carModel;
    private int numberOfCars;


    public SpeedPanel(CarModel carModel){
        this.carModel = carModel;
        this.numberOfCars = carModel.getNumberOfCars();
        this.labelList = new ArrayList<>();

        initializeComponents();
    }


    // TODO gör så att det är kompatibelt med den senare uppgiften
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
        initializeComponents();
        this.numberOfCars = carModel.getNumberOfCars();
        System.out.printf("Synchronize label list. Cars: %d \t List size: %d\n", numberOfCars, labelList.size());
    }


    public void updateSpeed(){
        this.repaint();

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
    }


}
