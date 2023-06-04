package test.interactions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.interactions.DroppablePage;
import test.TestBase;

public class DropDragTest extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getInteractions();
        new SidePanel(driver).selectDroppable();
    }

    @Test
    public void droppableTest(){
        new DroppablePage(driver).actionDragMe();
    }
    @Test
    public void dropableByTest(){
        new DroppablePage(driver).DragAndDroppBy(20,30);
    }    @Test
    public void dropableByIndexTest(){
        new DroppablePage(driver).DragAndDroppByIndex(200,300);
    }
}
