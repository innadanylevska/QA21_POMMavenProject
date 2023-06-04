package pages.bookStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

public class BookStoreShowPage extends BasePage {
    public BookStoreShowPage(WebDriver driver) {
        super(driver);
    }

    //ntf child 1 click
    @FindBy(xpath = "//span[@class='mr-2']/a")
    WebElement clickPositionOfFirstBook;

    public BookStoreShowPage clickPositionOfFirstBook() {
        click(clickPositionOfFirstBook);//??
        return new BookStoreShowPage(driver);
    }

    @FindBy(id = "title-label")
    WebElement nameOfBookInTitle;

    public BookStoreShowPage typeInTitleField(String text) {
        Assert.assertTrue(nameOfBookInTitle.getText().contains(text));
        return this;
    }

    //click add book
    @FindBy(id = "addNewRecordButton")
    WebElement addNewRecordBtn;

    public BookStoreShowPage addToYourCollection() {
        System.out.println("Let's go to Profile");
        clickWithJSExecutor(addNewRecordBtn, 0, 800);
        isAlertPresent();
        return this;
    }
}
