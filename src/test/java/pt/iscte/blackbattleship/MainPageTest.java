package pt.iscte.blackbattleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest {

    private WebDriver driver;

    @Test
    void testOpenMainPage() {
        driver = new ChromeDriver();

        MainPage mainPage = new MainPage(driver);
        mainPage.open();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(d -> d.getTitle().contains("JetBrains"));

        assertTrue(mainPage.getTitle().contains("JetBrains"));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}