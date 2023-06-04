package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class JSExecutor extends BasePage{
    JavascriptExecutor js;
    public JSExecutor(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }

    public JSExecutor enterDataWithJS(String user, String email) {
        if (user != null && email != null){
            js.executeScript("document.getElementById('userName').value='" +user + "';");
            js.executeScript("document.getElementById('userEmail').value='" + email + "';");
        }
        return this;
    }

    public JSExecutor clickOnSubmitWithJS() {
        js.executeScript("document.getElementById('submit').click()");
        return this;
    }

    public JSExecutor checkBoxWithJS() {
        //checkboxclick();
        js.executeScript("document.querySelector('#hobbies-checkbox-1').checked=false;");
        js.executeScript("document.querySelector('#hobbies-checkbox-1').checked=true;");
        //net id querySelector
        return this;
    }


    public JSExecutor refresh() {
        js.executeScript("history.go(0);");
        return this;
    }


}
