package test.widgets;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.widgets.SelectMenuPage;
import test.TestBase;

public class SelectTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getWidgets();
        new SidePanel(driver).selectMenu();
    }
    @Test
    public void selectValueTest(){
        new SelectMenuPage(driver).selectValue("Group 2, option 1");//
    }
    @Test
    public void selectOneTest(){
        new SelectMenuPage(driver).selectOne("Mrs.");//
    }
    @Test
    public void selectOldStyleTest(){
        new SelectMenuPage(driver).selectOldStyle("Green");
    }
    @Test
    public void selectRGBTest(){
        new SelectMenuPage(driver).multiSelect("Red");
    }
    @Test
    public void StandardMultiSelectTest(){
        new SelectMenuPage(driver).standardMultiSelect(1);
    }
}
