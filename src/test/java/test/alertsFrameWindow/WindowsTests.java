package test.alertsFrameWindow;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.alertsFrameWindows.BrowserWindowPage;
import pages.bookStore.ProfilePage;
import pages.widgets.SelectMenuPage;
import test.TestBase;

public class WindowsTests extends TestBase {
//https://www.selenium.dev/documentation/webdriver/interactions/windows/
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getAlertsFrameWindows();
        new SidePanel(driver).selectBrowserWindows();
    }

    @Test
    public void newTabTest(){
        new BrowserWindowPage(driver).clickByNewTabButton()
                .acceptByText("This is a sample page");
    }
    @Test
    public void newWindowTest(){
        new BrowserWindowPage(driver).clickByNewWindowButton()
                .acceptByText("This is a sample page");
    }

    @Test
    public void newMessageWindowTest(){
        new BrowserWindowPage(driver).clickByNewMessageWindowButton()
                .acceptByText("Knowledge increases ");
    }


}
