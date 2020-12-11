import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *  A class that has two buttons, add and remove car.
 *
 * @author Arianit Zeqiri, Jakob Stråhle, Veronica Segerlind
 * @version 1.0
 */
public class AddCarPanel extends JPanel {

    private JButton addCar;
    private JButton removeCar;

    private CarModel carModel;

    public AddCarPanel(CarModel carModel){
        this.carModel = carModel;

        initializeComponents();
    }

    private void initializeComponents(){
        addCar = new JButton("Add car");
        removeCar = new JButton("Remove car");

        this.setLayout(new GridLayout(1,2));

        this.add(addCar,0);
        this.add(removeCar,1);


        addCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(carModel.getNumberOfCars() < 10){
                    double xPosition = 0.0;
                    double yPosition = carModel.getNumberOfCars()*70.0;

                    carModel.addCar(CarFactory.createRandomVehicle(xPosition, yPosition));
                }
            }
        });


        removeCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.removeCar();
            }
        });


    }
}
