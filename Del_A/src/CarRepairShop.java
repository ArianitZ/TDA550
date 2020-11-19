import java.util.ArrayList;
import java.util.List;

public class CarRepairShop<V extends Vehicle> implements Transporter{

    private List<V> listOfCars;
    private final int maxCapacity;
    private Loader<V> repairShop;

    private final double xPosition;
    private final double yPosition;
    private final int directionOfEntrance;

    public CarRepairShop(){
        this.listOfCars = new ArrayList<>();
        maxCapacity = 10;
        xPosition = 1;
        yPosition = 1;
        directionOfEntrance = 90;
        repairShop = new Loader<>(listOfCars, maxCapacity);
    }

    public void load(V car) {
        repairShop.load(car);
        synchronizeCargo(this);
    }

    public V unload() {
        V vehicle =  repairShop.unload();
        try{
            vehicle.setxPosition(vehicle.getxPosition()-0.1);
            vehicle.setyPosition(vehicle.getyPosition()-0.1);
        } catch (NullPointerException e){
            System.out.println("Nothing to unload");
        }
        return vehicle;
    }

    private void synchronizeCargo(Transporter t) {
        repairShop.synchronizeCargo(t);
    }

    @Override
    public double getxPosition() {
        return xPosition;
    }

    @Override
    public double getyPosition() {
        return yPosition;
    }

    @Override
    public int getDirection() {
        return directionOfEntrance;
    }

    public static void main(String []args){
        CarRepairShop<Saab95> bilVerkstadSaab = new CarRepairShop<>();
//        CarRepairShop<Volvo240> bilVerkstadVolvo = new CarRepairShop<>();
//        CarRepairShop<Vehicle> bilVerkstadForAll = new CarRepairShop<>();
        Saab95 saab = new Saab95();
        System.out.printf("---Before verkstad-- \n (%f, %f)\n", saab.getxPosition(), saab.getyPosition());
        bilVerkstadSaab.load(saab);

        System.out.printf("---After verkstad-- \n (%f, %f)\n", saab.getxPosition(), saab.getyPosition());

        Scania truck = new Scania();
        truck.startEngine();
        truck.move();
        bilVerkstadSaab.synchronizeCargo(truck);

        System.out.printf("---After verkstad and scania-- \n (%f, %f)\n", saab.getxPosition(), saab.getyPosition());

//        bilVerkstadVolvo.load(new Volvo240());
//        bilVerkstadForAll.load(new Scania());
    }

}
