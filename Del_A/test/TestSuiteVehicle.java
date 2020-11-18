import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestVehicleGetters.class, TestVehicleColor.class, TestVehicleEngine.class,
                     TestVehicleMovable.class, TestSaab95.class, TestVolvo240.class})

public class TestSuiteVehicle {
}
