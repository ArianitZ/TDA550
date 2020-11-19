import java.util.List;
import java.util.Stack;

public class CarFerry<C extends Vehicle> {

    private Loader<C> loader;
    private List<C> cargo;
    private int maxCapacity;
    private Transporter transporter;

    public CarFerry(){
        cargo = new Stack<>();
        maxCapacity = 30;
        loader = new Loader<>(cargo, maxCapacity);
    }

    public void load(C vehicle){
        loader.load(vehicle);
        loader.synchronizeCargo(transporter);
    }

    public C unload(){

    }



}
