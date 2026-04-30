package pt.iscte.blackbattleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        mainPage = new MainPage(driver);
        mainPage.open();
    }

    @Test
    void testOpenMainPage() {
        assertTrue(mainPage.getTitle().contains("JetBrains"));
    }

    @Test
    void testSearchButtonOpensSearchInput() {
        mainPage.clickSearch();

        assertTrue(mainPage.isSearchInputVisible());
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}