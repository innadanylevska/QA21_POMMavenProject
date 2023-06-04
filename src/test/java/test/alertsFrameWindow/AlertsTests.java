package test.alertsFrameWindow;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.alertsFrameWindows.Alertspage;
import test.TestBase;

public class AlertsTests extends TestBase {
//https://demoqa.com/alerts
//    Click Button to see alert
//    On button click, alert will appear after 5 seconds
//    On button click, confirm box will appear
//    On button click, prompt box will appear
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getAlertsFrameWindows();
        new SidePanel(driver).selectAlerts();
    }
    @Test
    public void alertWithTimerTest(){
        new Alertspage(driver).clickByAlertButtonWithTimer();
    }
    @Test //click i alert cclick suite
    public void alertWithSelect(){
        new Alertspage(driver).clickByAlertButtonWithSelect("cancel")//from alertpage
                .assertBYResult("Cancel");
    }
    @Test
    public void sendToAlertTest(){
        new Alertspage(driver).sendTextToAlert("Hello World!")
                .accertByMessage("Hello World!");
    }
}
