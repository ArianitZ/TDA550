/**
 *  A class that creates all the objects needed to run the car application.
 *
 * @author Arianit Zeqiri, Jakob Stråhle, Veronica Segerlind
 * @version 1.0
 */
public class CarApplication {

    private static void createCars(CarModel model){
        Vehicle volvo = CarFactory.createVolvo240(0.0, 0.0);
        Vehicle saab = CarFactory.createSaab95(0.0, 70.0);
        Vehicle scania = CarFactory.createScania(0.0, 140.0);

        model.addCar(volvo);
        model.addCar(saab);
        model.addCar(scania);
    }


    public static void main(String[] args){

        CarModel model = new CarModel();
        createCars(model);

        CarController cc = new CarController(model);
        SpeedPanel speedPanel = new SpeedPanel(model);
        AddCarPanel addCarPanel = new AddCarPanel(model);

        CarView frame = new CarView("CarSim 1.0", cc, speedPanel, addCarPanel);

        cc.frame = frame.drawPanel;
        cc.startTimer();

     }

}
