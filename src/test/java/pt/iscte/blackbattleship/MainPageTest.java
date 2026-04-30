package pt.iscte.blackbattleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // 👈 melhoria

        mainPage = new MainPage(driver);
        mainPage.open();
    }

    @Test
    void testOpenMainPage() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> d.getTitle().contains("JetBrains"));

        Thread.sleep(5000); // 5s p ver o site

        assertTrue(mainPage.getTitle().contains("JetBrains"));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}