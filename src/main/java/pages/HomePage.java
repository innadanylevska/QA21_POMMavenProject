package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.bookStore.BookStorePage;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    //search
    @FindBy(xpath = "//*[text()='Book Store Application']")
    WebElement bookStoreApp;
    public BookStorePage getBookStore(){
        clickWithJSExecutor(bookStoreApp,0,800);
        return new BookStorePage(driver);
    }
    @FindBy(id="gotoStore")
    WebElement gotoStoreButton;

    public BookStorePage gotoBookStore() {
        System.out.println("Let's go to Book Store");
        clickWithJSExecutor(gotoStoreButton,0,500);
        return new BookStorePage(driver);
    }

    @FindBy(xpath = "//h5[.='Alerts, Frame & Windows']")
    WebElement alertsFrameWindows;

    public SidePanel getAlertsFrameWindows() {
        clickWithJSExecutor(alertsFrameWindows,0,400);
        return new SidePanel(driver);
    }
    @FindBy(xpath = "//h5[.='Widgets']")
    WebElement widgets;

    public SidePanel getWidgets() {
        clickWithJSExecutor(widgets,0,400);
        return new SidePanel(driver);
    }
    @FindBy(xpath = "//h5[.='Interactions']")
    WebElement interactions;

    public SidePanel getInteractions() {
        clickWithJSExecutor(interactions,0,400);
        return new SidePanel(driver);
    }
    @FindBy(xpath = "//h5[.='Elements']")
    WebElement elements;
    public SidePanel getElements() {
        clickWithJSExecutor(elements,0,400);
        return new SidePanel(driver);
    }
    @FindBy(xpath = "//h5[.='Forms']")
    WebElement forms;
    public SidePanel getForms() {
        clickWithJSExecutor(forms,0,400);
        return new SidePanel(driver);
    }
}
