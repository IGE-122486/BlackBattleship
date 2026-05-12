package pt.iscte.blackbattleship.bart.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pt.iscte.blackbattleship.bart.pages.UserStory5;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Page Test Class for UserStoryTest5.
 * Tests whether the user can open the Battleship game guides.
 */
public class UserStory5Test {

    private WebDriver driver;
    private UserStory5 page;

    /**
     * Initializes Firefox and the Page Object.
     */
    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        page = new UserStory5(driver);
    }

    /**
     * Tests the access to the game guides page.
     */
    @Test
    public void userCanOpenGameGuides() {
        page.openBattleshipPage();
        page.scrollToTop();
        page.openGameGuides();

        assertTrue(page.isGameGuidesPageOpened());
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