import java.util.Iterator;
import java.util.List;
import java.util.Stack;
/**
 *  A class that acts as the model part of an application that uses the MVC desgin pattern.
 *  Stores vehicles and can return an iterator of the stored vehicles.
 *
 * @author Arianit Zeqiri, Jakob Stråhle, Veronica Segerlind
 * @version 1.0
 */
public class CarModel implements Iterable<Vehicle>{

    private List<Vehicle> cars;
    private int numberOfCars;


    public CarModel(){
        cars = new Stack<>();
    }


    public void addCar(Vehicle car){
        this.cars.add(car);
        numberOfCars++;
    }


    public void removeCar(){
        if(numberOfCars > 0) {
            ((Stack<Vehicle>) this.cars).pop();
            numberOfCars--;
        }
    }


    public int getNumberOfCars(){
        return numberOfCars;
    }


    @Override
    public Iterator<Vehicle> iterator() {
        return this.cars.iterator();
    }
}
