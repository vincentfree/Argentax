package hello;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Vincent on 21-6-2015.
 */
public class testGreetingController {
    GreetingController greetingController = new GreetingController();

    @Test
    public void testGreeting() {
        greetingController.greeting("test");
        assertEquals(1L, new GreetingController().greeting("f").getId());
        assertEquals("Hello testmessage!", new GreetingController().greeting("testmessage").getContent());
    }
}
