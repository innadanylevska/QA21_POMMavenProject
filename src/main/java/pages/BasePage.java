package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.bookStore.BookStorePage;
import pages.bookStore.LoginPage;
import pages.bookStore.ProfilePage;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
//https://demoqa.com/profile
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    public boolean shouldHave(WebElement element, String text, int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }
    @FindBy(id = "close-fixedban")
    WebElement close;

    public void closeBanner() {
        click(close);
    }

    public void clickWithJSExecutor(WebElement element, int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
        element.click();
    }

    public void typeWithJSExecutor(WebElement element, String text, int x, int y) {
        if (text != null) {
            clickWithJSExecutor(element,x,y);
            element.clear();
            element.sendKeys(text);
        }
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
//until(ExpectedConditions.alertIsPresent())
    public boolean isAlertPresent() {

        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.alertIsPresent());

        if (alert == null) {
            //CONFIRM RETURN DISSMIS
            ////Store the alert text in a variable
            //String text = alert.getText();
            return false;
        } else {
            driver.switchTo().alert();// ПРОМПТ INTEAD //Type your message//alert.sendKeys("Selenium");
            alert.accept();
            return true;
        }
    }


//    @FindBy(xpath="//span[@class='mr-2']/a")
//    WebElement nameOfBook;
//    public BookStorePage assertNameOfBook(String text) {
//        Assert.assertTrue(nameOfBook.getText().contains(text));
//        return this;
//    } +     @FindBy(xpath="//span[@class='mr-2']/a")
//    WebElement nameOfBook;
//    public ProfilePage assertNameOfBook() {
//        Assert.assertTrue(nameOfBook.getText().contains("Git"));
//        return this;
//    }
    //no reklamma
public void hideAd() {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("document.getElementById('adplus-anchor').style.display='none';");

}
public void hideFooter(){
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("document.querySelector('footer').style.display='none';");


}
    //base helper
    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size()>0;
    }

    //base help
    public boolean isElementPresent2(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
    public boolean isElementDisplayed(WebElement element){
        return element.isDisplayed();
    }



}