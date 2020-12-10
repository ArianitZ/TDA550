public class CarApplication {

    public static void main(String[] args){


        Vehicle volvo = CarFactory.createVolvo240(0.0, 0.0);
        Vehicle saab = CarFactory.createSaab95(0.0, 70.0);
        Vehicle scania = CarFactory.createScania(0.0, 140.0);

        CarModel model = new CarModel();
        model.addCar(volvo);
        model.addCar(saab);
        model.addCar(scania);

        CarController cc = new CarController(model);
        SpeedPanel speedPanel = new SpeedPanel(model);
        AddCarPanel addCarPanel = new AddCarPanel(model);

        CarView frame = new CarView("CarSim 1.0", cc, speedPanel, addCarPanel);

        cc.frame = frame.drawPanel;

        cc.startTimer();

     }

}
