package pt.iscte.blackbattleship.rodrigo.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pt.iscte.blackbattleship.rodrigo.pages.UserStory11;

import java.time.Duration;

public class UserStory11Test {

    private WebDriver driver;
    private UserStory11 userStory11;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        userStory11 = new UserStory11(driver);
    }

    @Test
    public void shareOptionVisibleTest() {
        userStory11.openWebsite();

        Assertions.assertTrue(userStory11.isShareOptionVisible());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}