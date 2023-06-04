package pages.forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

public class ModalPage extends BasePage {
    public ModalPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement modalComponent;

    public ModalPage isModalComponentPresent() {
        isElementDisplayed(modalComponent);
        return this;
    }



}
