package test.bookStore;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.bookStore.BookStorePage;
import pages.bookStore.BookStoreShowPage;
import pages.bookStore.LoginPage;
import pages.bookStore.ProfilePage;
import pages.data.UserData;
import test.TestBase;

public class ProfileShowBookAddedTest extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getBookStore();
        new SidePanel(driver).greLoginPage();
        new LoginPage(driver)
                .login(UserData.USER_NAME, UserData.USER_PASSWORD)
                .assertAccount(UserData.USER_NAME);
        new ProfilePage(driver).getProfilePage();
    }
    @Test
    public void profileShowBookAddedTest(){
//        if (true){
//        new ProfilePage(driver).titleWord().assertNameOfBook("Git");
//    }else{
            new ProfilePage(driver).goToBookStore();
            new BookStorePage(driver).clickPositionOfFirstBook();
            new BookStoreShowPage(driver).addToYourCollection();
            new ProfilePage(driver).titleWord().assertNameOfBook("Git");

       // }
    }

}
