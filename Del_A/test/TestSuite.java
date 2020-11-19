import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestVehicleGetters.class, TestVehicleColor.class, TestVehicleEngine.class,
                     TestVehicleMovable.class, TestSaab95.class, TestVolvo240.class, TestTruck.class,
                     TestCarTransport.class, TestScania.class, TestLoader.class, TestCarRepairShop.class,
                     TestRamp.class, /*TestCarFerry.class*/})

public class TestSuite {
}
