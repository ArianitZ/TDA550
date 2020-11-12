import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestCarsGetters.class, TestCarsColor.class, TestCarsEngine.class,
                     TestCarsMovable.class, TestSaab95.class, TestVolvo240.class})

public class TestSuiteCars {
}
