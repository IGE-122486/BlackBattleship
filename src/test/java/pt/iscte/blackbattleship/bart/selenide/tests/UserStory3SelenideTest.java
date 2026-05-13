package pt.iscte.blackbattleship.bart.selenide.tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.iscte.blackbattleship.bart.selenide.pages.UserStory3Selenide;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Page Test Class for UserStory3 using Selenide.
 * Tests the flow of starting a Battleship game against a robot.
 */
public class UserStory3SelenideTest {

    private UserStory3Selenide page;

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

        page = new UserStory3Selenide();
    }

    /**
     * Tests whether the user can choose to play against a robot.
     */
    @Test
    public void userCanPlayAgainstRobotWithSelenide() {
        page.openHomePage();
        page.acceptConsentIfVisible();
        page.openBattleshipGame();
        page.selectRobotGame();

        assertTrue(page.isNicknameInputVisible());

        page.typeNickname("bart2304");
        page.confirmNickname();

        assertTrue(page.isGameRoomOpened());
    }

    /**
     * Closes the browser after each test.
     */
    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}