package hello;

import org.springframework.test.context.TestContextManager;

/**
 * Created by Vincent on 6-7-2015.
 */
public abstract class RunWithSpringJUnit4 {

    private TestContextManager testContextManager;

    public RunWithSpringJUnit4(){
        try{
            this.testContextManager = new TestContextManager(getClass());
            this.testContextManager.prepareTestInstance(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
