import java.util.ArrayList;
import java.util.List;

public class CarRepairShop<C extends Vehicle> {

    private List<C> listOfCars;

    public CarRepairShop(){
        this.listOfCars = new ArrayList<C>();
    }

    public void addCar(C car){
        listOfCars.add(car);
    }
    /*
    public static void main(String []args){
        CarRepairShop<Saab95> bilVerkstadSaab = new CarRepairShop<>();
        bilVerkstadSaab.addCar(new Saab95());
        bilVerkstadSaab.addCar(new Volvo240());
    }
    */
}
