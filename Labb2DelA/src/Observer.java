import java.util.Iterator;

public interface Observer {

    void actOnSpeedChange(Iterator<Vehicle> carIterator);
    void actOnPositionChange(Iterator<Vehicle> carIterator);
    void actOnNumberOfCarsChange(Iterator<Vehicle> carIterator);

}
