package pt.iscte.blackbattleship.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pt.iscte.blackbattleship.pages.BattleshipHomePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RobotGameTest {

    private WebDriver driver;
    private BattleshipHomePage homePage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        homePage = new BattleshipHomePage(driver);
        homePage.open();
    }

    @Test
    void testPlayVsRobotOptionIsAvailable() {
        assertTrue(homePage.isPlayVsRobotVisible());
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}