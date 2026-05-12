package pt.iscte.blackbattleship.rodrigo.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pt.iscte.blackbattleship.rodrigo.pages.UserStory9;

import java.time.Duration;

public class UserStory9Test {

    private WebDriver driver;
    private UserStory9 userStory9;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        userStory9 = new UserStory9(driver);
    }

    @Test
    public void accessPrivacyOrTermsPageTest() {
        userStory9.openWebsite();

        userStory9.clickPrivacyOrTermsLink();

        String url = userStory9.getCurrentUrl().toLowerCase();
        String page = userStory9.getPageSource().toLowerCase();

        Assertions.assertTrue(
                url.contains("privacy")
                        || url.contains("terms")
                        || page.contains("privacy")
                        || page.contains("terms")
        );
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}