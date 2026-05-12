package pt.iscte.blackbattleship.rodrigo.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pt.iscte.blackbattleship.rodrigo.pages.UserStory10;

import java.time.Duration;

public class UserStory10Test {

    private WebDriver driver;
    private UserStory10 userStory10;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        userStory10 = new UserStory10(driver);
    }

    @Test
    public void changeLanguageOptionsTest() {
        userStory10.openWebsite();

        userStory10.clickLanguageButton();

        String page = userStory10.getPageSource().toLowerCase();

        Assertions.assertTrue(
                page.contains("fr")
                        || page.contains("pt")
                        || page.contains("es")
        );
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}