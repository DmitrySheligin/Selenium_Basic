package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.pages.FeedBackPage;
import selenium.pages.FeedBackPageDone;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Task2 {
    static WebDriver driver;
    static FeedBackPage feedBackPage;
    static FeedBackPageDone feedBackPageDone;
    WebDriverWait wait;


    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        driver.manage().window().maximize();
        feedBackPage = PageFactory.initElements(driver, FeedBackPage.class);
        feedBackPageDone = PageFactory.initElements(driver, FeedBackPageDone.class);
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void initialFeedbackPage() throws Exception {
//         TODO:
//         check that all field are empty and no tick are clicked
//         "Don't know" is selected in "Genre"
//         "Choose your option" in "How do you like us?"
//         check that the button send is blue with white letters
        feedBackPage.checkAllFieldsEmptyAndNotSelected();
        feedBackPage.checkSendBtnColor();
    }

    @Test
    public void emptyFeedbackPage() throws Exception {
//         TODO:
//         click "Send" without entering any data
//         check fields are empty or null
//         check button colors
//         (green with white letter and red with white letters)

        feedBackPage.clickOnSendBtn();
        feedBackPageDone.checkAllFieldsEmpty();
        feedBackPageDone.checkButtonColors();

    }

    @Test
    public void notEmptyFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form, click "Send"
//         check fields are filled correctly
//         check button colors
//         (green with white letter and red with white letters)
        feedBackPage.enterName("Dmitry Sheligin");
        feedBackPage.enterAge(31);
        feedBackPage.selectLanguageCheckBox("English");
        feedBackPage.selectGender("Male");
        feedBackPage.selectHowYouLikeUs("Good");
        feedBackPage.fillTheCommentArea("Ok");
        feedBackPage.clickOnSendBtn();

        //check fields are filled correctly
        feedBackPageDone.verifyContainsText(driver, feedBackPageDone.getYourName(), "Dmitry Sheligin");
        feedBackPageDone.verifyContainsText(driver, feedBackPageDone.getYourAge(), 31);
        feedBackPageDone.verifyContainsText(driver, feedBackPageDone.getYourLanguage(), "English");
        feedBackPageDone.verifyContainsText(driver, feedBackPageDone.getYourGender(), "Male");
        feedBackPageDone.verifyContainsText(driver, feedBackPageDone.getYourOptionOfUs(), "Good");
        feedBackPageDone.verifyContainsText(driver, feedBackPageDone.getYourComment(), "Ok");

        feedBackPageDone.checkButtonColors();

    }

    @Test
    public void yesOnWithNameFeedbackPage() throws Exception {
//         TODO:
//         enter only name
//         click "Send"
//         click "Yes"
//         check message text: "Thank you, NAME, for your feedback!"
//         color of text is white with green on the background
        feedBackPage.enterName("Dmitry Sheligin");
        feedBackPage.clickOnSendBtn();
        feedBackPageDone.clickOnYesBtn();

        feedBackPageDone.verifyContainsText(driver, feedBackPageDone.getSubmitMessage(),
                "Thanks, Dmitry Sheligin, for your feedback!");

        feedBackPageDone.checkSubmitMessageColor();

    }

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {
//         TODO:
//         click "Send" (without entering anything
//         click "Yes"
//         check message text: "Thank you for your feedback!"
//         color of text is white with green on the background

        feedBackPage.clickOnSendBtn();
        feedBackPageDone.clickOnYesBtn();
        feedBackPageDone.verifyContainsText(driver, feedBackPageDone.getSubmitMessage(), "Thanks for your feedback!");
        feedBackPageDone.checkSubmitMessageColor();
    }

    @Test
    public void noOnFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form
//         click "Send"
//         click "No"
//         check fields are filled correctly


    }
}