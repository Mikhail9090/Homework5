package scenarios;

/**
 * Created by Mikhail_Churakov on 6/10/2017.
 */

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/Login.feature")
public class RunnerClass {
}
