package pt.iscte.blackbattleship.bart.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pt.iscte.blackbattleship.bart.pages.UserStory3;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Page Test Class for UserStoryTest3.
 * Tests the flow of starting a Battleship game against a robot.
 */
public class UserStory3Test {

    private WebDriver driver;
    private UserStory3 page;

    /**
     * Initializes Firefox and the Page Object.
     */
    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        page = new UserStory3(driver);
    }

    /**
     * Tests whether the user can choose to play against a robot and enter a nickname.
     */
    @Test
    public void userCanPlayAgainstRobot() {
        page.openHomePage();
        page.acceptConsentIfVisible();
        page.openBattleshipGame();
        page.selectRobotGame();

        assertTrue(page.isNicknameInputVisible());

        page.typeNickname("bart2304");
        page.confirmNickname();
    }

    /**
     * Closes Firefox.
     */
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}