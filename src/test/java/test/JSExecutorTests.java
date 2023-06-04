package test;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.JSExecutor;
import pages.SidePanel;
import pages.data.UserData;

public class JSExecutorTests extends TestBase{

    @Test
    public void executorTest(){
        new HomePage(driver).getElements();
        new SidePanel(driver).selectTextBox();
        new JSExecutor(driver)
                .enterDataWithJS(UserData.USER_NAME, UserData.USER_EMAIL)
                .clickOnSubmitWithJS();
    }
    @Test
    public void checkBoxWithJSTest(){
        new HomePage(driver).getElements();
        new SidePanel(driver).selectCheckBox();
        new JSExecutor(driver).checkBoxWithJS();
        new JSExecutor(driver).refresh();
    }
}
