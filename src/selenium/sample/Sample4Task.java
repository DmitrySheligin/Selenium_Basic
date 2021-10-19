package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static org.junit.Assert.*;

public class Sample4Task {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/site/examples/actions";

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        // declaration above:
        driver = new ChromeDriver();
        //open page:
        driver.get(base_url);
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void enterNumber() throws Exception {
//         TODO:
//        enter a number under "Number"
//        check that button is not clickable "Clear Result"
//        check that text is not displayed
//        click on "Result" button
//        check that text is displayed
//        check that the correct Text appears ("You entered number: "NUMBER YOU ENTERED"")
//        check that the button "Clear Result" is clickable now
//        click on "Clear Result"
//        check that the text is still (""), but it is not displayed
        int inputNumber = 32123123;
        String ClearResultButtonSelector = "#clear_result_button_number";
        String resultNumberSelector = "#result_number";
        String numberSelector = "number";
        String resultButtonSelector = "result_button_number";

        driver.get (base_url);
        assertTrue("Base url is not the same, as driver url", driver.getCurrentUrl().equals(base_url));
        WebElement number = driver.findElement((By.cssSelector(numberSelector)));
        if (number != null) {
            number.clear();
            number.sendKeys(Integer.toString(inputNumber));
            WebElement number = driver.findElement(By.cssSelector(clearResultButtonSelector));
            if (clearResult != null) {
        }



    }

    @Test
    public void clickOnLink() throws Exception {
//         TODO:
//        check current url is base_url
//        click on "This is a link to Homepage"
//        check that current url is not base_url
//        verify that current url is homepage

        assertFalse(showButton.isEnabled());
        assertFalse(text.isDisplayed()); // "I am here!" is NOT seen
        assertTrue(showButton.isEnabled()); // "Show" button is enabled (clickable)
        assertFalse(hideButton.isEnabled())
    }
}
