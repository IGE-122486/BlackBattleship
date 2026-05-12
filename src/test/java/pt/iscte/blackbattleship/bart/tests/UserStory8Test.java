package pt.iscte.blackbattleship.bart.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pt.iscte.blackbattleship.bart.pages.UserStory8;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Page Test Class for UserStoryTest8.
 * Tests whether the user can start a robot Battleship game.
 */
public class UserStory8Test {

    private WebDriver driver;
    private UserStory8 page;

    /**
     * Initializes Firefox and the Page Object.
     */
    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        page = new UserStory8(driver);
    }

    /**
     * Tests whether the user can create a robot game room after entering a nickname.
     */
    @Test
    public void userCanStartRobotGameRoom() {
        page.openHomePage();
        page.acceptConsentIfVisible();
        page.openBattleshipGame();
        page.selectRobotGame();
        page.typeNickname("bart567");
        page.confirmNickname();

        assertTrue(page.isGameRoomOpened());
    }

    /**
     * Closes Firefox after each test.
     */
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}