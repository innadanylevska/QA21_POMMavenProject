package pages.bookStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

import java.awt.print.Book;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "userName-value")
    WebElement user;

    public ProfilePage assertAccount(String uName){
    Assert.assertTrue(shouldHave(user, uName, 12));
    return this;
    }

    @FindBy(id="submit")
    WebElement submitButton;

    public LoginPage logout() {//posle logout to log page type funcbecause
        System.out.println("Let's out from file");
        click(submitButton);
        return new LoginPage(driver);
    }
    public ProfilePage titleWord() {
        String text = "Git";
        return this;//because we are here page
    }
    @FindBy(xpath="//span[@class='mr-2']/a")
    WebElement nameOfBook;

    public ProfilePage assertNameOfBook(String text) {
        Assert.assertTrue(shouldHave(nameOfBook,text,12));//.getText().contains(text));
        return this;
    }
    @FindBy(xpath="//span[.='Profile']")
    WebElement profile;

    public ProfilePage getProfilePage() {
        clickWithJSExecutor(profile, 0, 400);
        return this;
    }
    @FindBy(id="gotoStore")
    WebElement goToStoreButton;

    public BookStorePage goToBookStore() {
        System.out.println("Let's go to Book Store");
        clickWithJSExecutor(goToStoreButton,0,500);
        return new BookStorePage(driver);
    }

}