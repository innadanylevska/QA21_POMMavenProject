package pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.List;

public class SelectMenuPage extends BasePage {

    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="oldSelectMenu")
    WebElement oldSelectMenu;

    public SelectMenuPage selectOldStyle(String color) {
        //bez tag select druga strategy
        Select select = new Select(oldSelectMenu);
        select.selectByVisibleText(color);//deselect otmena//esli net text drugaya strategia// value i text
        //el print of spisok
        List<WebElement> options = select.getOptions();
        System.out.println(select.getFirstSelectedOption().getText() + "is first");

        //vse
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
        }

        return this;

    }
    @FindBy(xpath = "(//div[@class=' css-2b097c-container'])[3]")
    WebElement multiSelect;
    @FindBy(xpath = "//html")
    WebElement space;

    public SelectMenuPage multiSelect(String color1) {
        click(multiSelect);
        WebElement element = driver.findElement(By.xpath(String.format("//div[text()='%s']", color1)));//format zagadochniy xpath
        click(element);
        click(space);//out from space
        return this;
    }
    @FindBy(id="cars")
    WebElement cars;

    public SelectMenuPage standardMultiSelect(int index) {

        Select multi = new Select(cars);
                if(multi.isMultiple()){//select mutiple
                    multi.selectByIndex(index);
                }
        return this;
    }
    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[2]")
    WebElement selectValue;



    public SelectMenuPage selectValue(String value) {

        click(selectValue);
        WebElement element = driver.findElement(By.xpath(String.format("//div[text()='%s']", value)));//format zagadochniy xpath
        click(element);
        click(space);//out from space

//        Select value = new Select(selectValue);
//            value.selectByIndex(index);

        return this;
    }
    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[2]")
    WebElement selectOne;


    public SelectMenuPage selectOne(String one) {
        click(selectValue);
        WebElement element = driver.findElement(By.xpath(String.format("//div[text()='%s']", one)));//format zagadochniy xpath
        click(element);
        click(space);//out from space
//        Select one = new Select(selectOne);
//            one.selectByIndex(index);
        return this;
    }
}
