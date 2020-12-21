import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

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

    private List<ViewObserver> viewObservers;

    private final DrawPanel drawPanel;
    private final SpeedPanel speedPanel;
    private final AddCarPanel addCarPanel;

    private final JPanel carControlPanel = new JPanel();
    private final JPanel gasPanel = new JPanel();
    private final JPanel controlPanel = new JPanel();

    private JSpinner gasSpinner;
    private int gasAmount = 0;
    private final JLabel gasLabel = new JLabel("Amount of gas");

    private final JButton gasButton = new JButton("Gas");
    private final JButton brakeButton = new JButton("Brake");
    private final JButton turboOnButton = new JButton("Saab Turbo on");
    private final JButton turboOffButton = new JButton("Saab Turbo off");
    private final JButton liftBedButton = new JButton("Scania Lift Bed");
    private final JButton lowerBedButton = new JButton("Lower Lift Bed");

    private final JButton startButton = new JButton("Start all cars");
    private final JButton stopButton = new JButton("Stop all cars");


    public CarView(String frameName, int xDim, int yDim, SpeedPanel speedPanel, AddCarPanel addCarPanel){
        this.xDimension = xDim;
        this.yDimension = yDim;
        this.viewObservers = new ArrayList<>();

        this.speedPanel = speedPanel;
        this.addCarPanel = addCarPanel;
        this.drawPanel = new DrawPanel(xDimension, (int)(yDimension * 7.0/10));

        initComponents(frameName);
        initActionListeners();
    }


    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(xDimension, yDimension));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(speedPanel);
        this.add(addCarPanel);
        this.add(drawPanel);

        // TODO: ändra hårdkodning av 7.0
        carControlPanel.setPreferredSize(new Dimension(xDimension, (int)(yDimension/7.0)));
        carControlPanel.setLayout(new BorderLayout());

        SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, 100, 1);
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new GridLayout(2,1));
        gasPanel.add(gasLabel);
        gasPanel.add(gasSpinner);
        carControlPanel.add(gasPanel, BorderLayout.LINE_START);

        controlPanel.setLayout(new GridLayout(2,4));
        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setBackground(Color.CYAN);
        carControlPanel.add(controlPanel, BorderLayout.CENTER);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        carControlPanel.add(startButton, BorderLayout.PAGE_START);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        carControlPanel.add(stopButton, BorderLayout.PAGE_END);

        this.add(this.carControlPanel);


        this.pack();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private void initActionListeners(){
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyStartEngine();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyStopEngine();
            }
        });

        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyChangeInGas(gasAmount);
            }
        });

        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyChangeInBrake(gasAmount);
            }
        });

        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyTurboOn();
            }
        });

        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyTurboOff();
            }
        });

        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyLiftBed();
            }
        });

        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyLowerBed();
            }
        });

    }


    public void addObserver(ViewObserver viewObserver){
        this.viewObservers.add(viewObserver);
    }


    private void notifyStartEngine(){
        for (ViewObserver viewObserver : viewObservers){
            viewObserver.actOnStartEngine();
        }
    }


    private void notifyStopEngine(){
        for (ViewObserver viewObserver : viewObservers){
            viewObserver.actOnStopEngine();
        }
    }


    private void notifyChangeInGas(int gasAmount){
        for (ViewObserver viewObserver : viewObservers){
            viewObserver.actOnChangeInGas(gasAmount);
        }
    }


    private void notifyChangeInBrake(int gasAmount){
        for (ViewObserver viewObserver : viewObservers){
            viewObserver.actOnChangeInBrake(gasAmount);
        }
    }


    private void notifyTurboOn(){
        for (ViewObserver viewObserver : viewObservers){
            viewObserver.actOnTurboOn();
        }
    }


    private void notifyTurboOff(){
        for (ViewObserver viewObserver : viewObservers){
            viewObserver.actOnTurboOff();
        }
    }


    private void notifyLiftBed(){
        for (ViewObserver viewObserver : viewObservers){
            viewObserver.actOnLiftBed();
        }
    }


    private void notifyLowerBed(){
        for (ViewObserver viewObserver : viewObservers){
            viewObserver.actOnLowerBed();
        }
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