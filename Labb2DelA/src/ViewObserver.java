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
