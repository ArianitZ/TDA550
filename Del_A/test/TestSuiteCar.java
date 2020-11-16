import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestCarGetters.class, TestCarColor.class, TestCarEngine.class,
                     TestCarMovable.class, TestSaab95.class, TestVolvo240.class})

public class TestSuiteCar {
}
