package hello;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java8.En;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Vincent on 5-7-2015.
 */
public class ApiTestSteps {
    private final WebDriver webDriver;

    public ApiTestSteps(SharedDriver webDriver) {
        this.webDriver = webDriver;
        //this.driver = new driver;
    }


    @Given("^the website is active$")
    public void the_website_is_active() throws Throwable {
        // Express the Regexp above with the code you wish you had
        webDriver.manage().window().maximize();
        webDriver.get("http://localhost:8080/");

    }


    @When("^I want to add the name \"([^\"]*)\"$")
    public void I_want_to_add_the_name(String name) throws Throwable {
        webDriver.get("http://localhost:8080/greeting?name="+name);
    }

    @Then("^the name should be returned with an ID and the name \"([^\"]*)\"$")
    public void the_name_should_be_returned_with_an_ID_and_the_name(String name) throws Throwable {
        assertTrue("name should be"+name, webDriver.findElement(By.tagName("pre")).getText().contains(name));
        assertFalse("false test for fuction",webDriver.findElement(By.tagName("pre")).getText().contains(new StringBuilder().append(name).reverse()));
    }
}
