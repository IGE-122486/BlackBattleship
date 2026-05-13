package pt.iscte.blackbattleship.goncalo.tests;

import GoncaloPages.UserStory16;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * Classe de teste JUnit da User Story 16.
 *
 * Esta classe testa a navegação
 * entre diferentes páginas do jogo.
 *
 * @author Goncalo
 */
public class UserStory16Test {

    /**
     * Instância do WebDriver.
     */
    private WebDriver driver;

    /**
     * Instância da Page Object.
     */
    private UserStory16 userStory16;

    /**
     * Configuração inicial.
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
     * Testa navegação entre páginas.
     */
    @Test
    public void navigationBetweenPagesTest() {

        userStory16.openWebsite();

        userStory16.selectBattleship();
        userStory16.clickHomeButton();

        userStory16.selectTicTacToe();
        userStory16.clickHomeButton();

        userStory16.selectConnect4();
        userStory16.clickHomeButton();

        userStory16.selectGomoku();
        userStory16.clickHomeButton();

        userStory16.selectChess();
        userStory16.clickHomeButton();

        userStory16.selectLastGame();
        userStory16.clickHomeButton();
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