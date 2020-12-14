import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 *  A class that shows the speed of the vehicles contained in CarModel as a JLabel.
 *
 * @author Arianit Zeqiri, Jakob Stråhle, Veronica Segerlind
 * @version 1.0
 */
public class SpeedPanel extends JPanel implements Observer{

    private List<JLabel> labelList;
    private int xDimension;
    private int yDimension;


    public SpeedPanel(int xDim, int yDim){
        this.xDimension = xDim;
        this.yDimension = yDim;

        this.labelList = new ArrayList<>();

        initializePanel();
    }


    private void initializePanel(){
        add(new JLabel("Speed panel"));

        this.setPreferredSize(new Dimension(this.xDimension, this.yDimension));
        this.setBackground(Color.magenta);
    }


    private void updatePanel(){
        this.removeAll();
        for (JLabel label : labelList){
            this.add(label);
        }
    }


    @Override
    public void actOnSpeedChange(Iterator<Vehicle> carIterator){ updateSpeed(carIterator); }

    @Override
    public void actOnNumberOfCarsChange(Iterator<Vehicle> carIterator) {updateSpeed(carIterator);}

    @Override
    public void actOnPositionChange(Iterator<Vehicle> carIterator) { }


    private void updateSpeed(Iterator<Vehicle> carIterator){

        labelList.clear();

        while(carIterator.hasNext()){
            Vehicle car = carIterator.next();
            String carName = car.getModelName();
            double carSpeed = car.getCurrentSpeed();

            String labelString = carName + ": " + carSpeed;

            labelList.add(new JLabel(labelString));
        }

        this.updatePanel();
        this.repaint();
        this.doLayout();

    }

}
