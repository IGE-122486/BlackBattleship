package pt.iscte.blackbattleship.goncalo.tests;

import GoncaloPages.UserStory13;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * Classe de teste JUnit da User Story 13.
 *
 * Esta classe testa se o sistema aceita
 * corretamente um nickname válido.
 *
 * @author Goncalo
 */
public class UserStory13Test {

    /**
     * Instância do WebDriver.
     */
    private WebDriver driver;

    /**
     * Instância da Page Object.
     */
    private UserStory13 userStory13;

    /**
     * Configuração inicial.
     */
    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        userStory13 = new UserStory13(driver);
    }

    /**
     * Testa nickname válido.
     */
    @Test
    public void validateValidNicknameTest() {

        userStory13.openWebsite();

        userStory13.selectBattleshipGame();

        userStory13.clickPlayVsRobot();

        userStory13.enterValidNickname("Goncalo123");

        userStory13.clickContinue();
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