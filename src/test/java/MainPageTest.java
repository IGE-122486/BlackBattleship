package pt.iscte.blackbattleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest {

    private WebDriver driver;

    @Test
    void testOpenMainPage() {
        driver = new ChromeDriver();

        MainPage mainPage = new MainPage(driver);
        mainPage.open();

        assertTrue(mainPage.getTitle().contains("JetBrains"));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}