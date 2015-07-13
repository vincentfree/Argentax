package hello;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Vincent on 21-6-2015.
 */
public class testGreetingController {


    @Test
    public void testGreeting() {
        GreetingController greetingController = new GreetingController();
        greetingController.greeting("test");
        assertEquals(1L, new GreetingController().greeting("f").getId());
        assertEquals("Hello testmessage!", new GreetingController().greeting("testmessage").getContent());
    }

    @Test
    public void testRemoveAll() {
        GreetingController controller = new GreetingController();
        controller.greeting("removeAll");
        controller.removeAll();
        assertTrue(GreetingController.getGreetings().isEmpty());
    }

    @Test
    public void testRemove() {
        GreetingController greetingRemove = new GreetingController();
        GreetingController.getGreetings().clear();
        greetingRemove.greeting("remove");
        assertEquals("Hello remove!", greetingRemove.greeting("remove").getContent());
        assertFalse(greetingRemove.getByID(0).isEmpty());
        greetingRemove.remove("remove");
        //System.out.println(GreetingController.getGreetings().size());
        //System.out.println("");
        assertEquals(true, GreetingController.getGreetings().isEmpty());
    }

    @Test
    public void testGreetingList() {
        GreetingController greetingController = new GreetingController();
        greetingController.greetinglist();
    }

    @Test
    public void testRemoveID() {
        GreetingController greetingRemoveID = new GreetingController();
        GreetingController.getGreetings().clear();
        greetingRemoveID.greeting("RemoveID");
        assertEquals("Hello RemoveID!", GreetingController.getGreetings().get(GreetingController.getGreetings().size() - 1).getContent());
        greetingRemoveID.removeid((int) (GreetingController.getGreetings().get(GreetingController.getGreetings().size() - 1).getId() - 1));
    }
    @Test
    public void testGetByID(){
        GreetingController getByIDController = new GreetingController();
        GreetingController.getGreetings().clear();
        getByIDController.greeting("GetByID");
        int i = (int)(GreetingController.getGreetings().get(GreetingController.getGreetings().size()-1).getId()-1);
        assertEquals("Hello GetByID!",getByIDController.getByID(i));
    }
}
