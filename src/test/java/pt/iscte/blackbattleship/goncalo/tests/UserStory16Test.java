package pt.iscte.blackbattleship.goncalo.tests;

import pt.iscte.blackbattleship.goncalo.pages.UserStory16;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * Classe de teste JUnit da User Story 16.
 *
 * Esta classe testa a navegação entre
 * diferentes páginas de jogos.
 *
 * @author Goncalo
 */
public class UserStory16Test {

    /**
     * Instância do WebDriver.
     */
    private WebDriver driver;

    /**
     * Instância da Page Object Class.
     */
    private UserStory16 userStory16;

    /**
     * Configuração inicial do teste.
     */
    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        userStory16 = new UserStory16(driver);
    }

    /**
     * Testa a navegação entre jogos.
     */
    @Test
    public void navigationBetweenGamesTest() {

        userStory16.openWebsite();

        userStory16.selectBattleshipGame();
        userStory16.clickHomeButton();

        userStory16.selectTicTacToeGame();
        userStory16.clickHomeButton();

        userStory16.selectConnect4Game();
        userStory16.clickHomeButton();

        userStory16.selectGomokuGame();
        userStory16.clickHomeButton();

        String expectedUrl =
                "https://papergames.io/en/";

        String actualUrl =
                userStory16.getCurrentUrl();

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