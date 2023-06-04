package test.alertsFrameWindow;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.alertsFrameWindows.ModalWindowPage;
import test.TestBase;

public class ModalDialogTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getAlertsFrameWindows();
        new SidePanel(driver).getModalDialog();

    }
    //open wind
    @Test
    public void smallModalOpenedTest(){

    }
    @Test
    public void smallModalTest(){
        new ModalWindowPage(driver).clickCloseBtn("This is a small modal. ");

    }
    @Test
    public void smallModalXTest(){
        new ModalWindowPage(driver).clickXBtn("X");

    }
    @Test
    public void LargeModalTest(){
        new ModalWindowPage(driver).clickCloseButton("Close");
    }
    @Test
    public void LargeModalXTest(){
        new ModalWindowPage(driver).clickXButton("X");
    }
}
