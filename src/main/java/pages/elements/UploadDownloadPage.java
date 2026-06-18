package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

public class UploadDownloadPage extends BasePage {
    public UploadDownloadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "uploadFile")
    WebElement uploadFileInput;

    @FindBy(id = "uploadedFilePath")
    WebElement uploadedFilePath;

    @FindBy(id = "downloadButton")
    WebElement downloadButton;

    public UploadDownloadPage uploadFile(String filePath) {
        uploadFileInput.sendKeys(filePath);
        return this;
    }

    public UploadDownloadPage assertUploadedFilePathContains(String fileName) {
        Assert.assertTrue(uploadedFilePath.getText().contains(fileName),
                "Expected uploaded path to contain: " + fileName);
        return this;
    }

    public UploadDownloadPage clickDownloadButton() {
        clickWithJSExecutor(downloadButton, 0, 300);
        return this;
    }
}
