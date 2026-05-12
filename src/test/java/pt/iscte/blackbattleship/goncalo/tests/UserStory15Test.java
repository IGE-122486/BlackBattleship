package pt.iscte.blackbattleship.goncalo.tests;

import pt.iscte.blackbattleship.goncalo.pages.UserStory15;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * Classe de teste JUnit da User Story 15.
 *
 * Esta classe testa se o utilizador consegue
 * voltar à página inicial após abandonar o jogo.
 *
 * @author Goncalo
 */
public class UserStory15Test {

    /**
     * Instância do WebDriver.
     */
    private WebDriver driver;

    /**
     * Instância da Page Object Class.
     */
    private UserStory15 userStory15;

    /**
     * Configuração inicial do teste.
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
     * Testa o retorno à página inicial.
     */
    @Test
    public void returnToHomePageTest() {

        userStory15.openWebsite();

        userStory15.selectBattleshipGame();

        userStory15.clickPlayVsRobot();

        userStory15.clickAbortGame();

        userStory15.confirmAbortGame();

        userStory15.clickHomeButton();

        String expectedUrl =
                "https://papergames.io/en/";

        String actualUrl =
                userStory15.getCurrentUrl();

        Assertions.assertEquals(
                expectedUrl,
                actualUrl
        );
    }

    /**
     * Fecha o browser após o teste.
     */
    @AfterEach
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}