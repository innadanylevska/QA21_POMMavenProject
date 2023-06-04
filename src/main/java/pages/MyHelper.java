package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyHelper extends BasePage{
    public MyHelper(WebDriver driver) {
        super(driver);
    }
    // WAITStESTS oF wEBdRIVER https://www.selenium.dev/documentation/webdriver/waits/

    //Browser  OF iNTERACTION oF wEBdRIVER
    //a. Get browser information
    //1. driver.getTitle();
    //2. driver.getCurrentUrl();
    //B. Browser navigation
    //1. Navigate to //Longer way
    //driver.navigate().to("https://selenium.dev");
    //2. Back driver.navigate().back();
    //3. fORWVARD driver.navigate().forward();
    //4. rEFRESH driver.navigate().refresh();

    //+aLERTS   OF iNTERACTION oF wEBdRIVER  +
    ////1. Click the link to activate the alert
    //driver.findElement(By.linkText("See an example alert")).click();
    //
    ////Wait for the alert to be displayed and store it in a variable
    //Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    //
    ////Store the alert text in a variable
    //String text = alert.getText();
    //
    ////Press the OK button
    //alert.accept();
    //2.- cONFIRM DISMISS- //Click the link to activate the alert
    //driver.findElement(By.linkText("See a sample confirm")).click();
    //
    ////Wait for the alert to be displayed
    //wait.until(ExpectedConditions.alertIsPresent());
    //
    ////Store the alert in a variable
    //Alert alert = driver.switchTo().alert();
    //
    ////Store the alert in a variable for reuse
    //String text = alert.getText();
    //
    ////Press the Cancel button
    //alert.dismiss();
    //
    //3. aLERT pROMPT +

    //COOKIES  OF iNTERACTION oF wEBdRIVER  https://www.selenium.dev/documentation/webdriver/interactions/cookies/
    //MODAL OF iNTERACTION oF wEBdRIVER ID Working with IFrames and frames
    //Supported Browsers https://www.selenium.dev/documentation/webdriver/browsers/
    //WINDOWS OF iNTERACTION oF wEBdRIVER https://www.selenium.dev/documentation/webdriver/interactions/windows/
    //Virtual Authenticator crud  OF iNTERACTION oF wEBdRIVER https://www.selenium.dev/documentation/webdriver/interactions/virtual_authenticator/
    //aCTION KEYBOARD mOUSE pEN wHEEL Actions API https://www.selenium.dev/documentation/webdriver/actions_api/
    //eLEMENTS oF wEBdRIVER
    //A.
    // INFORMATION oF eLEMENTS oF wEBdRIVER
    //1. Fetching Attributes or Properties (By.name(("email_input")));
    @FindBy(name = "email_input")
    WebElement emailTxt;

    public MyHelper getAttribute(){
    //fetch the value property associated with the textbox
    String valueInfo = emailTxt.getAttribute("value");
    return this;
    }
    //2. Text Content (By.cssSelector("h1")).getText();
    //3. Get CSS Value  (By.linkText("More information...")).getCssValue("color");
    //4. Size and Position  (By.cssSelector("h1")).getRect();System.out.println(res.getX());
    //5. Tag Name (By.cssSelector("h1")).getTagName();
    //6. Is Selected (By.cssSelector("input[type='checkbox']:first-of-type")).isSelected();
    //7. Is Enabled (By.name("btnK")).isEnabled();
    //8. Is Displayed (By.name("email_input")).isDisplayed();

    //B.
    // Interacting with web elements oF eLEMENTS oF wEBdRIVER
    //There are only 5 basic commands that can be executed on an element:
    //
    //click (applies to any element)
    //send keys (only applies to text fields and content editable elements)
    //clear (only applies to text fields and content editable elements)
    //submit (only applies to form elements)
    //select (see Select List Elements)

    //c.
    //Finding web elements oF eLEMENTS oF wEBdRIVER
    //1. Evaluating entire DOM
    //WebElement vegetable = driver.findElement(By.className("tomatoes"));
    //
    //2. Evaluating a subset of the DOM
    // WebElement fruits = driver.findElement(By.id("fruits"));
    //WebElement fruit = fruits.findElement(By.className("tomatoes"));
    //
    //3. Optimized locator WebElement fruit = driver.findElement(By.cssSelector("#fruits .tomatoes"));
    //
    //4. All matching elements List<WebElement> plants = driver.findElements(By.tagName("li"));
    //
    //5. Get element (By.tagName("li"));
    //
    //for (WebElement element : elements) {
    //    System.out.println("Paragraph text:" + element.getText());
    //}
    //6. Find Elements From Element (By.tagName("div"));
    //// Get all the elements available with tag name 'p'
    //              List<WebElement> elements = element.findElements(By.tagName("p"));
    //              for (WebElement e : elements) {
    //                  System.out.println(e.getText());
    //              }
    //7. Get Active Element (By.cssSelector("[name='q']")).sendKeys("webElement");
    // Get attribute of current active element
    // String attr = driver.switchTo().activeElement().getAttribute("title");

    //D lOCATORS  oF eLEMENTS oF wEBdRIVER
    //https://www.selenium.dev/documentation/webdriver/elements/locators/

    //e File Upload oF eLEMENTS oF wEBdRIVER
    //
    //we want to import selenium-snapshot file.
//		driver.findElement(By.id("file-upload")).sendKeys("selenium-snapshot.jpg");
//		driver.findElement(By.id("file-submit")).submit();
//		if(driver.getPageSource().contains("File Uploaded!")) {
//        System.out.println("file uploaded");
//    }
//		else{
//        System.out.println("file not uploaded");
//    }


}
