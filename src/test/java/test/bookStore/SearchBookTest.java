package test.bookStore;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.bookStore.BookStorePage;
import test.TestBase;

public class SearchBookTest extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getBookStore();
    }
//guest
    @Test
     public void searchBookPositiveTest(){
        new BookStorePage(driver).typeInSearchField("Git")
                .assertNameOfBook("Git");
    }
}
