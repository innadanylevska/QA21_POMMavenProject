package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.alertsFrameWindows.Alertspage;
import pages.alertsFrameWindows.BrowserWindowPage;
import pages.alertsFrameWindows.ModalWindowPage;
import pages.bookStore.LoginPage;
import pages.bookStore.ProfilePage;
import pages.elements.BrokenLinksImagesPage;
import pages.forms.PracticeFormPage;
import pages.interactions.DroppablePage;
import pages.widgets.SelectMenuPage;

public class SidePanel extends BasePage {
    public SidePanel(WebDriver driver) {
        super(driver);
    }
    //side bar login link
@FindBy(xpath="//span[.='Login']")
    WebElement login;

    public LoginPage greLoginPage() {
        clickWithJSExecutor(login, 0, 400);
        return new LoginPage(driver);
    }

    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alerts;

    public Alertspage selectAlerts() {
        clickWithJSExecutor(alerts, 0,300);
        return new Alertspage(driver);
    }
    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindows;

    public BrowserWindowPage selectBrowserWindows() {
        clickWithJSExecutor(browserWindows,0,50);
        return new BrowserWindowPage(driver);
    }
    @FindBy(xpath = "//span[.='Select Menu']")
    WebElement selectMenu;

    public SelectMenuPage selectMenu() {
        clickWithJSExecutor(selectMenu,0,400);
        return new SelectMenuPage(driver);
    }
    @FindBy(xpath = "//span[.='Modal Dialogs']")
    WebElement modalDialog;

    public ModalWindowPage getModalDialog() {
        clickWithJSExecutor(modalDialog,0,400);
        return new ModalWindowPage(driver);
    }
    @FindBy(xpath = "//span[.='Droppable']")
    WebElement droppable;
    public DroppablePage selectDroppable() {
        clickWithJSExecutor(droppable,0,600);
        return new DroppablePage(driver);
    }
    @FindBy(xpath = "//span[.='Text Box']")
    WebElement textBox;

    public JSExecutor selectTextBox() {
        click(textBox);
        return new JSExecutor(driver);
    }
    @FindBy(xpath = "//span[.='Check Box']")
    WebElement checkBox;

    public JSExecutor selectCheckBox() {
        click(checkBox);
        return new JSExecutor(driver);
    }
    @FindBy(xpath = "//span[.='Broken Links - Images']")
    WebElement brokenLinksImages;

    public BrokenLinksImagesPage selectBrokenLinksImages() {
        clickWithJSExecutor(brokenLinksImages,0,500);
        return new BrokenLinksImagesPage(driver);
    }

    @FindBy(xpath = "//span[.='Practice Form']")
    WebElement practiceForm;
    public PracticeFormPage selectPracticeForm() {
        click(practiceForm);
        return new PracticeFormPage(driver);
    }
}
