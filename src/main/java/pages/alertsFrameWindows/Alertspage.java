package pages.alertsFrameWindows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.BasePage;

import java.time.Duration;

public class Alertspage extends BasePage {//extends i alt enter Alertpage constructor create

    public Alertspage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;

    public Alertspage clickByAlertButtonWithTimer() {
        click(timerAlertButton);
        WebDriverWait
                wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
        myAlert.accept();
        return this;
    }

    @FindBy(id="confirmButton")
    WebElement confirmButton;

    public Alertspage clickByAlertButtonWithSelect(String text) {//est text v alert
        click(confirmButton);
        if (text!=null&&text.equalsIgnoreCase("ok")){
            driver.switchTo().alert().accept();
        } else if (text!=null&&text.equalsIgnoreCase("cancel")) {
            driver.switchTo().alert().dismiss();

        }
        return this;
    }
    //Alerts
    @FindBy(id="confirmResult")
    WebElement confirmResult;

    public Alertspage assertBYResult(String text) {
        Assert.assertTrue(confirmResult.getText().contains(text));
        return this;
    }
//.alert().sendKeys(text);//PROMPT
    @FindBy(id="promtButton")
    WebElement promtButton;

    public Alertspage sendTextToAlert(String text) {
        click(promtButton);
        if (text!=null){
            driver.switchTo().alert().sendKeys(text);//PROMPT
        }
        driver.switchTo().alert().accept();
        return this;
    }
    @FindBy(id="promptResult")
    WebElement promptResult;

    public Alertspage accertByMessage(String message) {
        Assert.assertTrue(promptResult.getText().contains(message));
        return this;
    }
}
