package pages.interactions;

import com.beust.ah.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import javax.xml.crypto.dsig.XMLObject;

public class DroppablePage extends BasePage {
    public DroppablePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="draggable")
    WebElement dragMe;
    @FindBy(id="droppable")
    WebElement dropHere;
//dd po id locator 1 2 i peredali //x y i peretaskivaem

    public DroppablePage actionDragMe() {
        Actions actions = new Actions(driver);//openda selen lognye pols deystv
        actions.dragAndDrop(dragMe,dropHere).build().perform();//ne budet otrabativat bez build
        //beaa assert sys out
        String textTo = dropHere.getText();
        if (textTo.equalsIgnoreCase("Dropped!")) {
            System.out.println("pass");
        } else {
            System.out.println("Fail");
        }

        return this;
    }


    public DroppablePage DragAndDroppBy(int x, int y) {
        Actions actions = new Actions(driver);
        int xOffset1 = dragMe.getLocation().getX();
        int yOffset1 = dragMe.getLocation().getY();

        System.out.println("xOffset1->" + xOffset1 + "yOffseet1 ->" + yOffset1);

        int xOffset = dropHere.getLocation().getX();
        int yOffset = dropHere.getLocation().getY();
//minus 2-1 stroka i naugad
        System.out.println("xOffset->" + xOffset + "yOffseet ->" + yOffset);
        //rasnica nayti smeschenie
        xOffset = (xOffset - xOffset1) + x;
        yOffset = (yOffset - yOffset1) + y;
        actions.dragAndDropBy(dragMe, xOffset,yOffset).perform();

        String textTo = dropHere.getText();
        if (textTo.equalsIgnoreCase("Dropped!")) {
            System.out.println("pass");
        } else {
            System.out.println("Fail");
        }
        return this;
    }


    public DroppablePage DragAndDroppByIndex(int x, int y) {
        Actions actions = new Actions(driver);
        pause(2000);
        actions.dragAndDropBy(dragMe,x,y).build().perform();
        return this;
    }
}
