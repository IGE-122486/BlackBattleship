package pt.iscte.blackbattleship.bart.selenide.tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.iscte.blackbattleship.bart.selenide.pages.UserStory5Selenide;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Page Test Class for UserStory5 using Selenide.
 * Tests whether the user can open the Battleship game guides.
 */
public class UserStory5SelenideTest {

    private UserStory5Selenide page;

    /**
     * Configures Firefox, Allure listener, and Page Object before each test.
     */
    @BeforeEach
    public void setUp() {
        Configuration.browser = "firefox";
        Configuration.browserSize = "1296x816";
        Configuration.timeout = 25000;

        addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));

        page = new UserStory5Selenide();
    }

    /**
     * Tests the access to the game guides page.
     */
    @Test
    public void userCanOpenGameGuidesWithSelenide() {
        page.openBattleshipPage();
        page.scrollToTop();
        page.openGameGuides();

        assertTrue(page.isGameGuidesPageOpened());
    }

    /**
     * Closes the browser after each test.
     */
    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}