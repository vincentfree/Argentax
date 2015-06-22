package hello;

/**
 * Created by Vincent on 21-6-2015.
 */
public class Greeting {
    private final long id;
    private final String content;

    /**
     *
     * @param id id van app
     * @param content de content dat weergegeven wordt
     */
    public Greeting(long id, String content){
        this.id = id;
        this.content = content;
    }

    /**
     *
     * @return id van de applicatie
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @return huidige content
     */
    public String getContent() {
        return content;
    }
}