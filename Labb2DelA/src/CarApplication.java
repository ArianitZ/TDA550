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

        int xDimension = 1000;
        int yDimension = 1000;
        int maxNumberOfCars = 10;

        CarModel carModel = new CarModel(xDimension, (int)(yDimension*7.0/10), maxNumberOfCars);
        createCars(carModel);

        SpeedPanel speedPanel = new SpeedPanel(xDimension, (int)(yDimension/20.0));
        AddCarPanel addCarPanel = new AddCarPanel(xDimension, (int)(yDimension/20.0), carModel);

        CarView carView = new CarView("CarSimulation 1.0", xDimension, yDimension, speedPanel, addCarPanel);

        CarController carController = new CarController(carModel);

        carModel.addObserver(carView);
        carModel.addObserver(speedPanel);

        carView.addObserver(carController);
        carController.startTimer();


     }

}
