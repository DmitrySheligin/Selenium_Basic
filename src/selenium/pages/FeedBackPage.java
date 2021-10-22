package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static org.junit.Assert.*;


    public class FeedBackPage extends StartSamplePage {

        @FindBy(how = How.ID, using = "fb_name")
        private WebElement nameInput;

        @FindBy(how = How.ID, using = "fb_age")
        private WebElement ageInput;

        @FindBy(how = How.CSS, using = "[type='checkbox'][value='English']")
        private WebElement checkBoxEnglish;

        @FindBy(how = How.CSS, using = "[type='checkbox'][value='French']")
        private WebElement checkBoxFrench;

        @FindBy(how = How.CSS, using = "[type='checkbox'][value='Spanish']")
        private WebElement checkBoxSpanish;

        @FindBy(how = How.CSS, using = "[type='checkbox'][value='Chinese']")
        private WebElement checkBoxChinese;

        @FindBy(how = How.CSS, using = "[type='radio'][name='gender']")
        private List<WebElement> radioBtnGender;

        @FindBy(how = How.ID, using = "like_us")
        private WebElement likeUsDropDown;

        @FindBy(how = How.CSS, using = "#like_us>option")
        private List<WebElement> likeUsDDoptions;

        @FindBy(how = How.CSS, using = "[name='comment']")
        private WebElement commentArea;

        @FindBy(how = How.CSS, using = "button[type='submit']")
        private WebElement sendBtn;

        public void enterName(String value) {
            nameInput.clear();
            nameInput.sendKeys(value);
        }

        public void enterAge(String value) {
            ageInput.clear();
            ageInput.sendKeys(value);
        }

        public void enterAge(int value) {
            ageInput.clear();
            ageInput.sendKeys(String.valueOf(value));
        }

        public void selectLanguageCheckBox(String option) {

            switch (option) {
                case "English":
                    checkBoxEnglish.click();
                    break;

                case "French":
                    checkBoxFrench.click();
                    break;

                case "Spanish":
                    checkBoxSpanish.click();
                    break;

                case "Chinese":
                    checkBoxChinese.click();
                    break;
            }
        }

        public void selectGender(String value) {
            switch (value) {
                case "Male":
                    getRadioBtnGender().get(0).click();
                    break;
                case "Female":
                    getRadioBtnGender().get(1).click();
            }
        }

        public void selectHowYouLikeUs(String value) {
            switch (value) {
                case "Good":
                    getLikeUsDDoptions().get(1).click();
                    break;

                case "Ok, i guess":
                    getLikeUsDDoptions().get(2).click();
                    break;

                case "Bad":
                    getLikeUsDDoptions().get(3).click();
                    break;

                case "Why me?":
                    getLikeUsDDoptions().get(4).click();
                    break;
            }
        }

        public void fillTheCommentArea(String value) {
            commentArea.clear();
            commentArea.sendKeys(value);
        }

        public void clickOnSendBtn() {
            sendBtn.click();
        }

        public void checkAllFieldsEmptyAndNotSelected() {
            assertEquals("", getNameInput().getText());
            assertEquals("", getAgeInput().getText());
            assertFalse(checkBoxEnglish.isSelected());
            assertFalse(checkBoxFrench.isSelected());
            assertFalse(checkBoxSpanish.isSelected());
            assertFalse(checkBoxChinese.isSelected());
            assertFalse(getRadioBtnGender().get(0).isSelected());
            assertFalse(getRadioBtnGender().get(1).isSelected());
            assertTrue(getRadioBtnGender().get(2).isSelected());
            assertEquals("Choose your option", getLikeUsDDoptions().get(0).getText());

        }

        public void checkSendBtnColor() {

            assertEquals("rgba(245, 245, 245, 1)", sendBtn.getCssValue("color"));
            assertEquals("rgba(33, 150, 243, 1)", sendBtn.getCssValue("background-color"));
        }

        public void checkIsSelected(WebElement e) {
            assertTrue(e.isSelected());
        }

        public void checkFormAfterNoBtn() {
            System.out.println("nameInput.getText() = " + nameInput.getText());
        }

        public WebElement getNameInput() {
            return nameInput;
        }

        public WebElement getAgeInput() {
            return ageInput;
        }

        public WebElement getCheckBoxEnglish() {
            return checkBoxEnglish;
        }

        public WebElement getCheckBoxFrench() {
            return checkBoxFrench;
        }

        public WebElement getCheckBoxSpanish() {
            return checkBoxSpanish;
        }

        public WebElement getCheckBoxChinese() {
            return checkBoxChinese;
        }

        public List<WebElement> getRadioBtnGender() {
            return radioBtnGender;
        }

        public WebElement getLikeUsDropDown() {
            return likeUsDropDown;
        }

        public List<WebElement> getLikeUsDDoptions() {
            return likeUsDDoptions;
        }

        public WebElement getCommentArea() {
            return commentArea;
        }

        public WebElement getSendBtn() {
            return sendBtn;
        }

    }
