package pt.iscte.blackbattleship.goncalo.tests;

import pt.iscte.blackbattleship.goncalo.pages.UserStory14;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * Classe de teste JUnit da User Story 14.
 *
 * Esta classe testa se o sistema impede
 * o início do jogo sem nickname.
 *
 * @author Goncalo
 */
public class UserStory14Test {

    /**
     * Instância do WebDriver.
     */
    private WebDriver driver;

    /**
     * Instância da Page Object Class.
     */
    private UserStory14 userStory14;

    /**
     * Configuração inicial do teste.
     */
    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        userStory14 = new UserStory14(driver);
    }

    /**
     * Testa tentativa de iniciar jogo sem nickname.
     */
    @Test
    public void validateEmptyNicknameTest() {

        userStory14.openWebsite();

        userStory14.selectTicTacToeGame();

        userStory14.clickPlayVsRobot();

        userStory14.clickContinueWithoutNickname();

        String expectedMessage =
                "Please choose a respectful username";

        String actualMessage =
                userStory14.getErrorMessage();

        Assertions.assertEquals(
                expectedMessage,
                actualMessage
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