package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Task1 {
    WebDriver driver;

    @Before
    public void openPage() {

        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void errorOnText() {
//        TODO
//        enter a text instead of a number, check that correct error is seen
        String expectedError = "Please enter a number";
        String expectedErrorSelector = "#ch1_error";
        String inputFieldSelector = "#numb";
        String text = "abcdef";
        String submitSelector = ".w3-btn";

        WebElement inputField = driver.findElement(By.cssSelector(inputFieldSelector));
        WebElement error = driver.findElement(By.cssSelector(expectedErrorSelector));
        WebElement submit = driver.findElement(By.cssSelector(submitSelector));

        inputField.sendKeys(text);
        submit.click();
        assertEquals();
    }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO
//        enter number which is too small (below 50), check that correct error is seen

        WebElement numInput = driver.findElement(By.id("numb"));
        WebElement submit = driver.findElement(By.cssSelector(".w3-btn"));
        WebElement errorText = driver.findElement(By.id("ch1-error"));

        try {
            numInput.sendKeys("35");
            submit.click();
            Alert alert = driver.switchTo().alert();
            assertEquals("Number is too small", alert.getText());
        catch (AssertionError b) {
            System.out.println("Number is too small");
            b.printStackTrace();
        }
        
    }

    @Test
    public void errorOnNumberTooBig() {

//        BUG: if I enter number 666 no errors where seen
//        TODO
//        enter number which is too big (above 100), check that correct error is seen

        WebElement numInput = driver.findElement(By.id("numb"));
        WebElement submit = driver.findElement(By.cssSelector(".w3-btn"));
        WebElement errorText = driver.findElement(By.id("ch1-error"));

        try {
            numInput.sendKeys("120");
            submit.click();
            Alert alert = driver.switchTo().alert();
            assertEquals("Number is too big", alert.getText());
        catch (AssertionError c) {
                System.out.println("Number is too big");
                c.printStackTrace();
            }
        }
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
        WebElement numInput = driver.findElement(By.id("numb"));
        WebElement submit = driver.findElement(By.cssSelector(".w3-btn"));
        WebElement errorText = driver.findElement(By.id("ch1_error"));

        try {
            numInput.sendKeys("80");
            submit.click();
            Alert alert = driver.switchTo().alert();
            assertEquals("Square root of 80 is 8.94", alert.getText());
            alert.accept();
        } catch (AssertionError e) {
            System.out.println("Error in the first half of correctSquareRootWithRemainder");
            e.printStackTrace();
        }

        try {
            assertEquals("", errorText.getText());
        } catch (AssertionError e) {
            System.out.println("Error in the second half of correctSquareRootWithRemainder");
            e.printStackTrace();
        }


    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
    }
}
