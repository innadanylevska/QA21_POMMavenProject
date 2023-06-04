package test.forms;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.data.StudentData;
import pages.forms.ModalPage;
import pages.forms.PracticeFormPage;
import test.TestBase;

import static java.awt.SystemColor.text;

public class ModalTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm();
        new PracticeFormPage(driver).hideAd();
        new PracticeFormPage(driver).hideFooter();
        new PracticeFormPage(driver).enterPracticeForm(StudentData.FIRST_NAME, StudentData.LAST_NAME,StudentData.EMAIL,StudentData.PHONE)
                .selectGender(StudentData.GENDER).typeOfDate(StudentData.DATE)
                //.chooseDate("08 May 2012");
                .addSubject(StudentData.SUBJECTS).cooseHobby(StudentData.HOBBIES)
                .uploadFile(StudentData.PHOTO_PATH).enterAddress(StudentData.ADDRESS)
                .inputeState(StudentData.STATE).inputCity(StudentData.CITY)
                .submitForm();
    }
    @Test
    public void openedModalPageTest() {
        new ModalPage(driver).isModalComponentPresent();
    }
}
