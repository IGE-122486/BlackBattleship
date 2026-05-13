package pt.iscte.blackbattleship.bart.selenide.tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.iscte.blackbattleship.bart.selenide.pages.UserStory8Selenide;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Page Test Class for UserStory8 using Selenide.
 * Tests whether the user can start a robot Battleship game.
 */
public class UserStory8SelenideTest {

    private UserStory8Selenide page;

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

        page = new UserStory8Selenide();
    }

    /**
     * Tests whether the user can create a robot game room.
     */
    @Test
    public void userCanStartRobotGameRoomWithSelenide() {
        page.openHomePage();
        page.acceptConsentIfVisible();
        page.openBattleshipGame();
        page.selectRobotGame();
        page.typeNickname("bart567");
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