package test.elements;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.elements.UploadDownloadPage;
import test.TestBase;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class UploadAndDownloadTests extends TestBase {

    private static final String UPLOAD_FILE_NAME = "sample-upload.txt";
    private static final String DOWNLOAD_FILE_NAME = "sampleFile.jpeg";
    private static final File DOWNLOAD_DIR = new File("target/downloads");

    @BeforeMethod
    public void configureDriver() {
        if (driver != null) {
            driver.quit();
        }

        DOWNLOAD_DIR.mkdirs();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("remote-allow-origins=*");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", DOWNLOAD_DIR.getAbsolutePath());
        prefs.put("download.prompt_for_download", false);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod(dependsOnMethods = "configureDriver")
    public void precondition() {
        new HomePage(driver).getElements();
        new SidePanel(driver).selectUploadAndDownload();
        new UploadDownloadPage(driver).hideAd();
    }

    @Test
    public void uploadFileTest() throws URISyntaxException {
        new UploadDownloadPage(driver)
                .uploadFile(getResourcePath(UPLOAD_FILE_NAME))
                .assertUploadedFilePathContains(UPLOAD_FILE_NAME);
    }

    @Test
    public void downloadFileTest() {
        new UploadDownloadPage(driver).clickDownloadButton();

        File downloadedFile = new File(DOWNLOAD_DIR, DOWNLOAD_FILE_NAME);
        long deadline = System.currentTimeMillis() + 10000;
        while (!downloadedFile.exists() && System.currentTimeMillis() < deadline) {
            new UploadDownloadPage(driver).pause(500);
        }

        Assert.assertTrue(downloadedFile.exists(), "Downloaded file was not found: " + downloadedFile.getAbsolutePath());
    }

    private String getResourcePath(String fileName) throws URISyntaxException {
        URL resource = getClass().getClassLoader().getResource(fileName);
        return Paths.get(resource.toURI()).toString();
    }
}
