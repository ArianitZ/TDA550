import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *  A class that controls the buttons of the CarView as well as the animated part of an.
 *
 * @author Arianit Zeqiri, Jakob Stråhle, Veronica Segerlind
 * @version 1.0
 */
public class CarController{
    private final int delay = 20;

    private final int xDimension;
    private final int yDimension;

    private final Timer timer = new Timer(delay, new TimerListener());

    private final CarModel carModel;
    private final CarView carView;

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


    public CarController(int xDim, int yDim, CarModel model, CarView carView){
        this.xDimension = xDim;
        this.yDimension = yDim;

        this.carModel = model;
        this.carView = carView;

        initComponents();
    }


    private void initComponents() {
        carControlPanel.setPreferredSize(new Dimension(xDimension, yDimension));
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

        carView.add(this.carControlPanel);
        carView.pack();


        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.gas(gasAmount);
            }
        });


        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.brake(gasAmount);
            }
        });


        startButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.startEngine();
            }
        });


        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.stopEngine();
            }
        });


        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.turboOn();
            }
        });


        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.turboOff();
            }
        });


        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.liftBed();
            }
        });


        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.lowerBed();
            }
        });

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
