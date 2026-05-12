package pt.iscte.blackbattleship.rodrigo.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pt.iscte.blackbattleship.rodrigo.pages.UserStory12;

import java.time.Duration;

public class UserStory12Test {

    private WebDriver driver;
    private UserStory12 userStory12;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        userStory12 = new UserStory12(driver);
    }

    @Test
    public void accessPaperGamesHomePageTest() {
        userStory12.openWebsite();

        userStory12.clickPaperGamesHomeLink();

        Assertions.assertTrue(
                userStory12.getCurrentUrl().contains("papergames.io")
        );
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}