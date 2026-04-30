package pt.iscte.blackbattleship.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pt.iscte.blackbattleship.pages.BattleshipHomePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InstructionsTest {

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
    void testViewRules() {
        homePage.scrollToRules();

        assertTrue(homePage.areRulesVisible());
        assertTrue(homePage.pageContains("turn-based"));
        assertTrue(homePage.pageContains("10x10 grid"));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}