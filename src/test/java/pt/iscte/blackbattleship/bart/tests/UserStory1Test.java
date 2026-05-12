package pt.iscte.blackbattleship.bart.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pt.iscte.blackbattleship.bart.pages.UserStory1;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Page Test Class for UserStoryTest1.
 * Tests whether a visitor can create a guest nickname and enter a Battleship game room.
 */
public class UserStory1Test {

    private WebDriver driver;
    private UserStory1 page;

    /**
     * Initializes Firefox and the Page Object before each test.
     */
    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        page = new UserStory1(driver);
    }

    /**
     * Tests the nickname creation flow.
     */
    @Test
    public void userCanCreateNickname() {
        page.openHomePage();
        page.acceptConsentIfVisible();
        page.openBattleshipGame();
        page.selectRobotGame();

        assertTrue(page.isNicknameInputVisible());

        page.typeNickname("bart23456");
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