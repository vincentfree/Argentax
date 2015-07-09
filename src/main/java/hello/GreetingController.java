package hello;

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

    //TODO testcase maken
    @RequestMapping("/remove")
    public void remove(@RequestParam(value = "remove", defaultValue = "") String name) {
        int i = 101010101;
        for (Greeting greet : greetings) {
            if (greet.getContent().contains(name)) {
                i = ((int) greet.getId() - 1);
                System.out.println(greet.getContent());
            }
            if (i != 101010101) {
                greetings.remove(i);
                break;

            } else {
                return;
            }
        }

    }

    //TODO testcase maken
    @RequestMapping("/removeid")
    public void removeid(@RequestParam(value = "id") int ID) {
        greetings.remove(ID);
    }

    //TODO testcase maken
    @RequestMapping("/greetinglist")
    public String greetinglist() {
        return "greeting\ngreeting?name=\nall\nremove?remove=\nremoveall";
    }

    //TODO testcase maken getByID
    @RequestMapping("/getByID")
    public String getByID(@RequestParam(value = "id") int ID) {

        return greetings.get(ID).getContent();

    }
}