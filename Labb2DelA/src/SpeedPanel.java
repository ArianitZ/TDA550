import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SpeedPanel extends JPanel {

    List<JLabel> labelList;
    CarModel carModel;

    public SpeedPanel(CarModel carModel){
        this.carModel = carModel;
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

    public void updateSpeed(){
        //this.paintComponent(this.getGraphics());

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
