import java.awt.*;

public class CarsTransport extends Truck{

    public CarsTransport(){
        truck = new Scania(2, 100.0, 0.0, Color.blue, "transporter",
                           90,0.0, 0.0);
    }

    public void raiseTruckBed(){
        truck.increaseTruckBedAngle(70);
    }

    public void lowerTruckBed(){
        truck.decreaseTruckBedAngle(0);
    }

    public void main (String[] args){
        CarsTransport lastbil = new CarsTransport();
        lastbil.raiseTruckBed();
    }
}
