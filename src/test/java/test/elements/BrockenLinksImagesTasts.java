package test.elements;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.elements.BrokenLinksImagesPage;
import test.TestBase;

public class BrockenLinksImagesTasts extends TestBase {//deleted 404 links

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getElements();
        new SidePanel(driver).selectBrokenLinksImages();
    }
    @Test
    public void checkAllLinksTest(){//all chto nashli
        new BrokenLinksImagesPage(driver).checkAllLinks();
    }
    @Test
    public void checkBrockenLinksTest(){
        new BrokenLinksImagesPage(driver).checkBrockenLinks();
    }
    @Test
    public void checkBrockenImageLinksTest(){
        new BrokenLinksImagesPage(driver).checkBrockenImageLinks();
    }

}
