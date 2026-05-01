package pt.iscte.blackbattleship.rodrigo.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pt.iscte.blackbattleship.rodrigo.pages.RodrigoHomePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RodrigoHomePageTest {

    private WebDriver driver;
    private RodrigoHomePage homePage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        homePage = new RodrigoHomePage(driver);
        homePage.open();
    }

    @Test
    void us01_playButtonIsVisible() {
        assertTrue(homePage.isPlayButtonVisible());
    }

    @Test
    void us02_instructionsLinkIsVisible() {
        assertTrue(homePage.isInstructionsLinkVisible());
    }

    @Test
    void us03_clickPlayChangesPageState() {
        homePage.clickPlay();

        assertTrue(homePage.pageChangedAfterPlay());
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}