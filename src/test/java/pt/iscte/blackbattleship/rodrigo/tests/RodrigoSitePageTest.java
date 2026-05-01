package pt.iscte.blackbattleship.rodrigo.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pt.iscte.blackbattleship.rodrigo.pages.RodrigoSitePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RodrigoSitePageTest {

    private WebDriver driver;
    private RodrigoSitePage page;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        page = new RodrigoSitePage(driver);
        page.open();
    }

    @Test
    void us09_accessPrivacyPage() {
        assertTrue(page.hasPrivacyLink());
        page.clickPrivacyLink();
        assertTrue(page.openedPrivacyPage());
    }

    @Test
    void us10_openLanguageOptions() {
        assertTrue(page.hasLanguageButton());
        page.clickLanguageButton();
        assertTrue(page.languageMenuOpened());
    }

    @Test
    void us11_shareOptionVisible() {
        assertTrue(page.hasShareOption());
    }

    @Test
    void us12_accessPaperGamesHomePage() {
        assertTrue(page.hasPaperGamesHomeLink());
        page.clickPaperGamesHomeLink();
        assertTrue(page.openedPaperGamesHomePage());
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}