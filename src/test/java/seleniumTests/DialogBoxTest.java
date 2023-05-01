package seleniumTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.avSelenium.CarPage;
import pageObjects.avSelenium.HomePage;
import pageObjects.avSelenium.LoginPage;
import pageObjects.baseObjects.BaseTest;

public class DialogBoxTest extends BaseTest {
    @BeforeTest
    public void openPage() {
        get(HomePage.class)
                .open();
    }

    @BeforeMethod
    public void preconditions() {
        get(HomePage.class)
                .clickLoginBtn();
        get(LoginPage.class)
                .loginWithEmail();
    }

    @Test(description = "Car price changes dialog box display",
            priority = 1,
            enabled = true)
    public void carDialogBoxTest() {
        get(HomePage.class)
                .goToCarPage();
        get(CarPage.class)
                .clickPriceChangesBtn()
                .verifyPriceChangesBox()
                .verifyPriceChangesBoxText()
                .clickClosePriceChangesBoxBtn();
    }

    @Test(description = "User message dialog box display",
            priority = 2,
            enabled = true)
    public void userMsgDialogBoxTest() {
        get(HomePage.class)
                .clickUserMsgBtn()
                .verifyUserMsgBox()
                .verifyUserMsgBoxText()
                .clickCloseUserMsgBtn();
    }

    @AfterMethod
    public void postconditions() {
        get(HomePage.class)
                .logout();
    }
}
