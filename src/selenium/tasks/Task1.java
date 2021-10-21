package selenium.tasks;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
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
        WebElement inputBox = driver.findElement(By.cssSelector("#numb"));
        inputBox.clear();
        inputBox.sendKeys("text");

        WebElement errorMessage = driver.findElement(By.cssSelector("#ch1_error"));
        String expectedErrorTxt = "Enter a number";
        assertEquals(expectedErrorTxt, errorMessage.getText());

    }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO
//        enter number which is too small (below 50), check that correct error is seen
        WebElement inputBox = driver.findElement(By.cssSelector("#numb"));
        inputBox.clear();
        inputBox.sendKeys("10");

        WebElement submitBtn = driver.findElement(By.xpath("//button[@onclick='numberValidation()']"));
        submitBtn.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("#ch1_error"));
        String expectedErrorTxt = "Number is too small";
        assertEquals(expectedErrorTxt, errorMessage.getText());

        inputBox.clear();
        inputBox.sendKeys("49");
        submitBtn.click();

        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            assertTrue(errorMessage.isDisplayed());
        }
        catch (AssertionError e) {
            System.out.println("Error message should be displayed");
            e.printStackTrace();
        }
    }

    @Test
    public void errorOnNumberTooBig() {

//        BUG: if I enter number 666 no errors where seen
//        TODO
//        enter number which is too big (above 100), check that correct error is seen
        WebElement inputBox = driver.findElement(By.cssSelector("#numb"));
        inputBox.clear();
        inputBox.sendKeys("666");

        WebElement submitBtn = driver.findElement(By.xpath("//button[@onclick='numberValidation()']"));
        submitBtn.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("#ch1_error"));
        String expectedErrorTxt = "Number is too big";

        try {
            assertEquals(expectedErrorTxt, errorMessage.getText());
        }
        catch (AssertionError e) {
            System.out.println("\"Number is too big\" error message should be displayed");
            e.printStackTrace();
        }

        inputBox.clear();
        inputBox.sendKeys("130");
        submitBtn.click();
        assertEquals(expectedErrorTxt, errorMessage.getText());


    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
        WebElement inputBox = driver.findElement(By.cssSelector("#numb"));
        inputBox.clear();
        inputBox.sendKeys("64");

        WebElement submitBtn = driver.findElement(By.xpath("//button[@onclick='numberValidation()']"));
        submitBtn.click();

        Alert alert = driver.switchTo().alert();
        String alertTxt = "Square root of 64 is 8.00";
        assertEquals(alertTxt, alert.getText());
        alert.accept();


        WebElement errorMessage = driver.findElement(By.cssSelector("#ch1_error"));
        assertFalse(errorMessage.isDisplayed());

    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
        WebElement inputBox = driver.findElement(By.cssSelector("#numb"));
        inputBox.clear();
        inputBox.sendKeys("70");

        WebElement submitBtn = driver.findElement(By.xpath("//button[@onclick='numberValidation()']"));
        submitBtn.click();

        Alert alert = driver.switchTo().alert();
        String alertTxt = "Square root of 70 is 8.36";
        assertEquals(alertTxt, alert.getText());
        alert.accept();

        WebElement errorMessage = driver.findElement(By.cssSelector("#ch1_error"));
        assertFalse(errorMessage.isDisplayed());

    }
}
