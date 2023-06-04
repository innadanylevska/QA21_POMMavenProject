package pages.forms;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;


public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    //    @FindBy(id = "")
//    WebElement ;
    @FindBy(id = "firstName")
    WebElement fName;
    @FindBy(id = "lastName")
    WebElement lName;
    @FindBy(id = "userEmail")
    WebElement userEmail;
    @FindBy(id = "userNumber")
    WebElement userNumber;


    public PracticeFormPage enterPracticeForm(String firstName, String lastName, String email, String phone) {
        type(fName, firstName);
        type(lName, lastName);
        type(userEmail, email);
        type(userNumber, phone);
        return this;
    }

    @FindBy(css = "[for='gender-radio-1']")
    WebElement male;
    @FindBy(css = "[for='gender-radio-2']")
    WebElement female;
    @FindBy(css = "[for='gender-radio-3']")
    WebElement other;

    public PracticeFormPage selectGender(String gender) {
        if (gender.equals("Male")) {
            click(male);
        } else if (gender.equals("Female")) {
            click(female);
        } else {
            click(other);
        }
        return this;
    }

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirth;

    public PracticeFormPage typeOfDate(String date) {
        click(dateOfBirth);
        String os = System.getProperty("os.name");//kakaya operac windows //alt enter
        System.out.println("MY OS is:" + os);
        if (os.startsWith("Mac")) {
            dateOfBirth.sendKeys(Keys.COMMAND, "a");
        } else {
            dateOfBirth.sendKeys(Keys.COMMAND, "a");
        }

        dateOfBirth.sendKeys(date);
        dateOfBirth.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;

    public PracticeFormPage addSubject(String[] subjects) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null) {
                typeWithJSExecutor(subjectsInput, subjects[i], 0, 200);
                subjectsInput.sendKeys(Keys.ENTER);
            }

        }
        return this;
    }

    @FindBy(css = "[for=hobbies-checkbox-1]")
    WebElement sports;
    @FindBy(css = "[for=hobbies-checkbox-2]")
    WebElement reading;
    @FindBy(css = "[for=hobbies-checkbox-3]")
    WebElement music;

    public PracticeFormPage cooseHobby(String[] hobbies) {
        for (int i = 0; i < hobbies.length; i++) {
            if (hobbies[i].equals("Sports")) {
                click(sports);
            }
            if (hobbies[i].equals("Reading")) {
                click(reading);
            }
            if (hobbies[i].equals("Music")) {
                click(music);
            }

        }
        return this;
    }


    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;

    public PracticeFormPage uploadFile(String photoPath) {
        uploadPicture.sendKeys(photoPath);
        return this;
    }

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    public PracticeFormPage enterAddress(String address) {
        typeWithJSExecutor(currentAddress, address, 0, 300);
        return this;
    }

    @FindBy(id = "state")
    WebElement stateContainer;
    @FindBy(id = "react-select-3-input")
    WebElement stateInput;//strokovie razno name

    public PracticeFormPage inputeState(String state) {
        click(stateContainer);
        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "city")
    WebElement cityContainer;
    @FindBy(id = "react-select-4-input")
    WebElement cityInput;

    public PracticeFormPage inputCity(String city) {
        click(cityContainer);
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.ENTER);
        return this;
    }
    @FindBy(id = "submit")
    WebElement submit;

    public PracticeFormPage submitForm() {
        clickWithRectangle(submit,3,3);//delim click po verhu btm submit
        return this;
    }

    public void clickWithRectangle(WebElement element, int x, int y) {
        Rectangle rectangle = element.getRect();
        int xOffset = rectangle.getWidth() / x;
        int yOffset = rectangle.getHeight() / y;
                       //Actions cursor lognoe polsovat deyctvie .perform(); i tochka
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.moveByOffset(-xOffset,-yOffset).click().perform();
    }

}
