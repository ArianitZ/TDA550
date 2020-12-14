import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

/**
 *  A class that acts as the view in our car application.
 *  It communicates with the Controller by calling methods of it when an action fires of in
 *  each of it's components.
 *
 * @author Arianit Zeqiri, Jakob Stråhle, Veronica Segerlind
 * @version 1.0
 */
public class CarView extends JFrame implements Observer{
    private final int xDimension;
    private final int yDimension;

    private final DrawPanel drawPanel;
    private final SpeedPanel speedPanel;
    private final AddCarPanel addCarPanel;


    public CarView(String frameName, int xDim, int yDim, SpeedPanel speedPanel, AddCarPanel addCarPanel){
        this.xDimension = xDim;
        this.yDimension = yDim;

        this.speedPanel = speedPanel;
        this.addCarPanel = addCarPanel;
        this.drawPanel = new DrawPanel(xDimension, (int)(yDimension * 7.0/10));

        initComponents(frameName);
    }


    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(xDimension, yDimension));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(speedPanel);
        this.add(addCarPanel);
        this.add(drawPanel);

        this.pack();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    @Override
    public void actOnSpeedChange(Iterator<Vehicle> carIterator) { }


    @Override
    public void actOnPositionChange(Iterator<Vehicle> carIterator) {
        while (carIterator.hasNext()){
            drawPanel.move(carIterator.next());
        }
        drawPanel.paint();
    }


    @Override
    public void actOnNumberOfCarsChange(Iterator<Vehicle> carIterator) {

        actOnPositionChange(carIterator);
    }
}