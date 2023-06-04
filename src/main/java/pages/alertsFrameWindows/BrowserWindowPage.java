package pages.alertsFrameWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowPage extends BasePage {

    public BrowserWindowPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="tabButton")
    WebElement newTabButton;

    public BrowserWindowPage clickByNewTabButton() {
        click(newTabButton);
        //array of tabs [0],[1]-suda vo vtoryu List<string> = new Arraylist<>(driver.getWindowHendle) for pages for vkladki
        //bez id as modal
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;

    }
    @FindBy(id="sampleHeading")
    WebElement sampleHeading;

    public BrowserWindowPage acceptByText(String message) {
        Assert.assertTrue(shouldHave(sampleHeading,message,15));
        return this;
    }
    @FindBy(id="windowButton")
    WebElement newWindowButton;
    public BrowserWindowPage clickByNewWindowButton() {
            click(newWindowButton);
            //array of tabs [0],[1]-suda vo vtoryu List<string> = new Arraylist<>(driver.getWindowHendle) for pages for vkladki
            List<String> windows = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(windows.get(1));
            return this;

        }
        @FindBy(id="messageWindowButton")
        WebElement newMessageWindowButton;

    public BrowserWindowPage clickByNewMessageWindowButton() {
        click(newMessageWindowButton);
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        return this;
    }



}
