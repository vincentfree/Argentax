package hello;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by Vincent on 5-7-2015.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/",
        plugin = {"html:target/cukes", "json:target/cucumber/tests.cucumber"})
public class RunAllCucumberTest {
}