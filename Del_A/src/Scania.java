// Polymorphism needed - Yes
// Code reuse - Yes
// Is-A car - Yes?
// Roles - No, a truck is always a truck and a Saab95 is always a Saab95


import java.awt.*;
public class Scania extends Truck{

    // TODO change engine power
    public Scania(){
        super(2, 100.0, 0.0, Color.blue, "Scania", 90, 0.0, 0.0, 0, 70);
    }


}
