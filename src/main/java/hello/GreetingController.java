package hello;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Vincent on 21-6-2015.
 */

@RestController
public class GreetingController {

    private static final String template = "Hello %s!";
    private final AtomicLong counter = new AtomicLong();

    public static ArrayList<Greeting> getGreetings() {
        return greetings;
    }

    private static ArrayList<Greeting> greetings = new ArrayList<>();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        greetings.add(new Greeting(counter.incrementAndGet(), String.format(template, name)));
        return greetings.get(greetings.size() - 1);
    }

    @RequestMapping("/all")
    public ArrayList all() {
        return greetings;
    }

    @RequestMapping("/removeall")
    public void removeAll() {
        greetings.clear();
    }


    @RequestMapping("/remove")
    public void remove(@RequestParam(value = "remove", defaultValue = "") String name) {
        int i = 101010101;
        int[] x = new int[greetings.size()];
        int up = greetings.size() - 1;
        for (Greeting greet : greetings) {
            if (greet.getContent().contains(name)) {
                i = ((int) greet.getId() - 1);
                //System.out.println(greet.getContent());
            }
            if (i != 101010101) {
                x[up] += i;
                up--;

            } else {
                return;
            }
        }
        for (int s : x) {
            if (greetings.isEmpty()) {
                break;
            } else {
                greetings.remove(s);
            }

        }

    }

    /**
     * @param ID de ID die je wil verwijderen.
     */
    @RequestMapping("/removeid")
    public void removeid(@RequestParam(value = "id") int ID) {
        greetings.remove(ID);
    }

    /*
    Greetinglist geeft een lijst van functies terug die te gebruiken zijn op de REST api.
     */
    @RequestMapping("/list")
    public String greetinglist() {
        return "greeting" + '\n' + "greeting?name=" + '\n' + "all" + '\n' + "remove?remove=" + '\n' + "removeall" + '\n' + "getByID?id=";
    }

    //TODO testcase maken getByID
    @RequestMapping("/getByID")
    //TODO Exeption handling maken voor wanneer hij array out of bound gaat
    public String getByID(@RequestParam(value = "id") int ID) {

        return greetings.get(ID).getContent();

    }
}
