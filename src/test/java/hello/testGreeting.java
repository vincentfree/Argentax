package hello;

import org.junit.Test;
import org.junit.Assert.*;


import static org.junit.Assert.assertEquals;

/**
 * Created by Vincent on 21-6-2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)   // 1
@SpringApplicationConfiguration(classes = Application.class)   // 2
@WebAppConfiguration   // 3
@IntegrationTest("server.port:0")   // 4
public class testGreeting {
    Greeting greeting = new Greeting(1l,"Vincent Free");

    @Test
    public void testId(){
        assertEquals(1L,greeting.getId());
    }
    @Test
    public void testContent(){
        assertEquals("Vincent Free",greeting.getContent());
    }
}
