package pages.alertsFrameWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

import java.util.Arrays;

public class ModalWindowPage extends BasePage {
    public ModalWindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="showSmallModal")
    WebElement showSmallModal;
    @FindBy(id="closeSmallModal")
    WebElement closeSmallButton;
    @FindBy(xpath = "//span[.='x']")
    WebElement xSmall;
//    @FindBy(id="example-modal-sizes-title-sm")
//    WebElement goToSmallModal;

    public ModalWindowPage clickCloseBtn(String text) {
        click(showSmallModal);
        //if (text!=null&&text.equalsIgnoreCase("close")) {
            acceptByRes(text);

        // driver.findElement(By.id("example-modal-sizes-title-sm"));//goToSmallModal
            click(closeSmallButton);
       // }
        return this;
    }
    @FindBy(xpath = "//p[.='This is a small modal. ']")
    WebElement sampleHeading;

    public ModalWindowPage acceptByRes(String text) {
        Assert.assertTrue(shouldHave(sampleHeading, text, 15));
        return this;
    }

    @FindBy(id="showLargeModal")
    WebElement showLargeModal;
    @FindBy(id="closeLargeModal")
    WebElement closeLargeButton;
    @FindBy(xpath = "//span[.='x']")
    WebElement xLarge;

    public ModalWindowPage clickCloseButton(String text) {
        click(showLargeModal);
        if (text!=null&&text.equalsIgnoreCase("close")) {
            acceptByRes(text);//"Lorem Ipsum is simply dummy"

            //driver.findElement(By.id("example-modal-sizes-title-lg"));
            click(closeLargeButton);

        }
        return this;

    }

    public ModalWindowPage clickXBtn(String text) {
        if (text!=null&&text.equalsIgnoreCase("x")) {
            click(showSmallModal);
            driver.findElement(By.id("example-modal-sizes-title-sm"));
            acceptByRes("Lorem Ipsum is simply dummy");
            click(xLarge);
        }
        return this;
    }

    public ModalWindowPage clickXButton(String text) {
        if (text!=null&&text.equalsIgnoreCase("x")) {
            click(showLargeModal);
            driver.findElement(By.id("example-modal-sizes-title-lg"));
            acceptByRes("Lorem Ipsum is simply dummy");
            click(xLarge);
        }
        return this;
    }





//    public static void mm(int[] arr){
//        Arrays.stream(arr);
//    }



}
