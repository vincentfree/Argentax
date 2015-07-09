package hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;

/**
 * Created by Vincent on 21-6-2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)   // 1
@SpringApplicationConfiguration(classes = Application.class)   // 2
//@IfProfileValue(name="test-groups", values={"unit-tests", "integration-tests"})
@WebAppConfiguration   // 3
@IntegrationTest("server.port:1")   // 4
public class ITestGreeting {
    Greeting greeting = new Greeting(1l, "Vincent Free");
    //GreetingController greetingController = new GreetingController();

    @Test
    public void testId() {
        //SpringApplication.run(Application.class);
        assertEquals(1L, greeting.getId());
    }

    @Test
    public void testContent() {
        //SpringApplication.run(Application.class);
        assertEquals("Vincent Free", greeting.getContent());
    }
}