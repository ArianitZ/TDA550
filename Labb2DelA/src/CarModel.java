import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarModel implements Iterable<Vehicle>{

    private List<Vehicle> cars;

    public CarModel(){
        cars = new ArrayList<>();
    }

    public void addCar(Vehicle car){
        this.cars.add(car);
    }

    @Override
    public Iterator<Vehicle> iterator() {
        return this.cars.iterator();
    }
}
