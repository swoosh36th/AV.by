package seleniumTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.avSelenium.BookmarksPage;
import pageObjects.avSelenium.HomePage;
import pageObjects.avSelenium.LoginPage;
import pageObjects.avSelenium.UserSettingsPage;
import pageObjects.baseObjects.BaseTest;
import steps.CheckOpenPageSteps;

public class PopupMsgTest extends BaseTest {

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

    @Test(description = "Popup message when adding car to bookmarks",
            priority = 1,
            enabled = true)
    public void popupMsgHomeTest() {
        get(HomePage.class)
                .addInterestingTodayCarToBookmarks()
                .verifyPopupMsg();
    }

    @Test(description = "Popup message when removed car from bookmarks",
            priority = 2,
            dependsOnMethods = "popupMsgHomeTest",
            enabled = true)
    public void popupMsgBookmarksTest() {
        get(HomePage.class)
                .goToBookmarks();
        get(CheckOpenPageSteps.class)
                .verifyBookmarksAreOpen();
        get(BookmarksPage.class)
                .verifyBookmarksAreNotEmpty()
                .deleteAllCarsFromBookmarks()
                .verifyPopupMsg();
    }

    @Test(description = "Popup message when when changing password",
            priority = 3,
            enabled = true)
    public void popupMsgUserSettingsTest() {
        get(HomePage.class)
                .goToUserSettings();
        get(CheckOpenPageSteps.class)
                .verifyUserSettingsAreOpen();
        get(UserSettingsPage.class)
                .changePsw(properties.getProperty("password"))
                .verifyPopupMsg();
    }

    @AfterMethod
    public void postconditions() {
        get(HomePage.class)
                .logout();
    }
}
