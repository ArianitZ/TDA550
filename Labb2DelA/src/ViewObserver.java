/**
 *  An interface that acts as an observer for a car view.
 *
 * @author Arianit Zeqiri, Jakob Stråhle, Veronica Segerlind
 * @version 1.0
 */
public interface ViewObserver {

    void actOnStartEngine();
    void actOnStopEngine();
    void actOnChangeInGas(int gasAmount);
    void actOnChangeInBrake(int gasAmount);
    void actOnTurboOn();
    void actOnTurboOff();
    void actOnLiftBed();
    void actOnLowerBed();

}
