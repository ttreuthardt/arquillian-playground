package li.obiwan.arquillian.test.unit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestServiceTest.class, GamesServiceTest.class, ServletTest.class })
public class AllTests {

}
