package pt.iscte.blackbattleship.goncalo.tests;

import GoncaloPages.UserStory15;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * Classe de teste JUnit da User Story 15.
 *
 * Esta classe testa o regresso
 * à página inicial.
 *
 * @author Goncalo
 */
public class UserStory15Test {

    /**
     * Instância do WebDriver.
     */
    private WebDriver driver;

    /**
     * Instância da Page Object.
     */
    private UserStory15 userStory15;

    /**
     * Configuração inicial.
     */
    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        userStory15 = new UserStory15(driver);
    }

    /**
     * Testa regresso à página inicial.
     */
    @Test
    public void returnToHomePageTest() {

        userStory15.openWebsite();

        userStory15.selectBattleshipGame();

        userStory15.clickPlayVsRobot();

        userStory15.enterNickname("Goncalo123");

        userStory15.clickContinue();

        userStory15.clickAbortButton();

        userStory15.clickConfirmButton();

        userStory15.clickHomeButton();
    }

    /**
     * Fecha o browser.
     */
    @AfterEach
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}