package pt.iscte.blackbattleship.bart.selenide.tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.iscte.blackbattleship.bart.selenide.pages.UserStory1Selenide;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Page Test Class for UserStory1 using Selenide.
 * Tests whether a visitor can create a nickname and enter a Battleship game room.
 */
public class UserStory1SelenideTest {

    private UserStory1Selenide page;

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

        page = new UserStory1Selenide();
    }

    /**
     * Tests the nickname creation flow using Selenide.
     */
    @Test
    public void userCanCreateNicknameWithSelenide() {
        page.openHomePage();
        page.acceptConsentIfVisible();
        page.openBattleshipGame();
        page.selectRobotGame();

        assertTrue(page.isNicknameInputVisible());

        page.typeNickname("bart23456");
        page.confirmNickname();

        assertTrue(page.isGameRoomOpened());

        closeWebDriver();
    }
}