package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

public class Sample7Task {
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
    public void selectCheckBox() throws Exception {
//         TODO:
//        check that none of the checkboxes are ticked
//        tick  "Option 2"
//        check that "Option 1" and "Option 3" are not ticked, but "Option 2" is ticked
//        tick  "Option 3"
//        click result
//        check that text 'You selected value(s): Option 2, Option 3' is being displayed
            List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));

            for (WebElement checkBox : checkBoxes) {
                assertFalse(checkBox.isSelected()); // checkboxes are NOT selected
                checkBox.click();
                WebElement option3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='checkbox']"));
                assertFalse(option3.isSelected());

                WebElement datePicker = driver.findElement(By.id("vfb-8"));
                datePicker.click();
                WebElement calWidget = driver.findElement(By.id("ui-datepicker-div"));
                WebElement calBack = calWidget.findElement(By.className("ui-datepicker-prev"));
                WebElement calMonth = calWidget.findElement(By.className("ui-datepicker-month"));
                WebElement calYear = calWidget.findElement(By.className("ui-datepicker-year"));
                while (!((calMonth.getText() == "2007") && (calYear.getText() == "July"))) {
                    calBack.click();
                    Thread.sleep(100);
                    calBack = calWidget.findElement(By.className("ui-datepicker-prev"));
                    calMonth = calWidget.findElement(By.className("ui-datepicker-month"));
                    calYear = calWidget.findElement(By.className("ui-datepicker-year"));
                }
    }


    @Test
    public void selectRadioButton() throws Exception {
//         TODO:
//        check that none of the radio are selected
//        select  "Option 3"
//        check that "Option 1" and "Option 2' are not select, but "Option 3" is selected
//        select  "Option 1"
//        check that "Option 2" and "Option 3' are not select, but "Option 1" is selected
//        click result
//        check that 'You selected option: Option 1' text is being displayed
    }

    @Test
    public void selectOption() throws Exception {
//        select "Option 3" in Select
//        check that selected option is "Option 3"
//        select "Option 2" in Select
//        check that selected option is "Option 2"
//        click result
//        check that 'You selected option: Option 2' text is being displayed
    }

    @Test
    public void chooseDateViaCalendarBonus() throws Exception {
//         TODO:
//        enter date '4 of July 2007' using calendar widget
//        check that correct date is added
    }

    @Test
    public void chooseDateViaTextBoxBonus() throws Exception {
//         TODO:
//        enter date '2 of May 1959' using text
//        check that correct date is added

                WebElement datePicker = driver.findElement(By.id("vfb-8"));
                datePicker.sendKeys("05/02/1959");

                //Click outside of the calendar widget to close it, because the result button is behind it
                driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/h2")).click();
                driver.findElement(By.id("result_button_date")).click();

                assertEquals("You entered date: 05/02/1959", driver.findElement(By.id("result_date")).getText());

            }
    }
}
