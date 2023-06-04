package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    public WebDriver driver;//public add after
    @BeforeMethod
    public void setUp(){

        //if(browser.equalsIgnoreCase("Chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("remote-allow-origins=*");
            driver = new ChromeDriver(options);
           // logger.info("All tests start in chrome browser");
       // }else if (browser.equalsIgnoreCase("firefox")){
           // driver = new FirefoxDriver();
           // logger.info("All tests start in firefox browser");
        //} else if (browser.equalsIgnoreCase("edge")) {
           //EdgeOptions options = new EdgeOptions();
           // options.addArguments("remote-allow-origins=*");
           // driver = new EdgeDriver();
          //  logger.info("All tests start in edge browser");
       // }
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod(enabled = false)
    public void stop() {
        driver.quit();
    }
}
