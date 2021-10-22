package selenium.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

    public class FeedBackPageDone extends StartSamplePage {

        WebDriverWait wait;

        @FindBy(how = How.XPATH, using = "//p[text()='Your name: ']")
        private WebElement yourName;

        @FindBy(how = How.XPATH, using = "//p[text()='Your age: ']")
        private WebElement yourAge;

        @FindBy(how = How.XPATH, using = "//p[text()='Your language: ']")
        private WebElement yourLanguage;

        @FindBy(how = How.XPATH, using = "//p[text()='Your genre: ']")
        private WebElement yourGender;

        @FindBy(how = How.XPATH, using = "//p[text()='Your option of us: ']")
        private WebElement yourOptionOfUs;

        @FindBy(how = How.XPATH, using = "//p[text()='Your comment: ']")
        private WebElement yourComment;

        @FindBy(how = How.CSS, using = ".w3-green")
        private WebElement yesBtn;

        @FindBy(how = How.CSS, using = ".w3-red")
        private WebElement noBtn;

        @FindBy(how = How.CSS, using = ".w3-panel")
        private WebElement submitMessage;



        public void checkAllFieldsEmpty() {
            assertEquals("Your name:", yourName.getText());
            assertEquals("Your age:", yourAge.getText());
            assertEquals("Your language:", yourLanguage.getText());
            assertEquals("Your genre: null", yourGender.getText());
            assertEquals("Your option of us: null", yourOptionOfUs.getText());
            assertEquals("Your comment:", yourComment.getText());
        }

        public void checkButtonColors() {

            assertEquals("rgba(76, 175, 80, 1)", yesBtn.getCssValue("background-color"));
            assertEquals("rgba(220, 220, 220, 1)", yesBtn.getCssValue("color"));
            assertEquals("rgba(244, 67, 54, 1)", noBtn.getCssValue("background-color"));
            assertEquals("rgba(220, 220, 220, 1)", noBtn.getCssValue("color"));



        }

        public void verifyContainsText(WebDriver driver, WebElement element, String msg)
        {
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(element));
            assertTrue(element.getText().toLowerCase().contains(msg.toLowerCase()));
        }

        public void verifyContainsText(WebDriver driver, WebElement element, int value)
        {
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(element));
            assertTrue(element.getText().contains(String.valueOf(value)));
        }

        public void checkSubmitMessageColor() {

            assertEquals("rgba(220, 220, 220, 1)", submitMessage.getCssValue("color"));
            assertEquals("rgba(76, 175, 80, 1)", submitMessage.getCssValue("background-color"));

        }

        public void clickOnYesBtn() {
            yesBtn.click();
        }



        public WebElement getYourName() {
            return yourName;
        }

        public WebElement getYourAge() {
            return yourAge;
        }

        public WebElement getYourLanguage() {
            return yourLanguage;
        }

        public WebElement getYourGender() {
            return yourGender;
        }

        public WebElement getYourOptionOfUs() {
            return yourOptionOfUs;
        }

        public WebElement getYourComment() {
            return yourComment;
        }

        public WebElement getSubmitMessage() {
            return submitMessage;
        }
    }

