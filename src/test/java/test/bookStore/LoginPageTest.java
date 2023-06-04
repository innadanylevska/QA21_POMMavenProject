package test.bookStore;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.bookStore.LoginPage;
import pages.bookStore.ProfilePage;
import pages.data.UserData;
import test.TestBase;

public class LoginPageTest extends TestBase {



    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getBookStore();
        new SidePanel(driver).greLoginPage();
    }
    @Test(enabled = false)//1 raz login true odno
    public void loginPositiveTest(){
       // new LoginPage(driver).closeBaner();//no work use
        new LoginPage(driver)
                .login(UserData.USER_NAME, UserData.USER_PASSWORD)
                .assertAccount(UserData.USER_NAME);//uName
//        new LoginPage(driver).login("InnaD", "1234!NNa")
//                .assertAccount("neur");//uName
    }
    @Test
    @Parameters({"name", "password"})//testng
    public void loginPositiveWithParametrsTest(String name,String password){
       // new LoginPage(driver).closeBaner();//no work use
        new LoginPage(driver)
                .login(name,password)
                .assertAccount(name);//uName
//        new LoginPage(driver).login("InnaD", "1234!NNa")
//                .assertAccount("neur");//uName
    }
    @AfterMethod
    public void
    postCondition(){
        new ProfilePage(driver).logout();
    }
}
