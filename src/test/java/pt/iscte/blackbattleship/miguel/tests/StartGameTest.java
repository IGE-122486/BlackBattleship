package pt.iscte.blackbattleship.miguel.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pt.iscte.blackbattleship.pages.BattleshipHomePage;
import pt.iscte.blackbattleship.miguel.pages.GamePageMiguel;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StartGameTest {

    private WebDriver driver;

    @Test
    void testStartNewGame() throws InterruptedException {
        driver = new ChromeDriver();

        // 1. abrir homepage (REUTILIZAS o código do colega)
        BattleshipHomePage home = new BattleshipHomePage(driver);
        home.open();

        Thread.sleep(3000); //esperar para dar o consentimento no site

        // 2. iniciar jogo
        home.clickPlayVsRobot();

        Thread.sleep(2000);

        // 3. validar que o jogo começou
        GamePageMiguel game = new GamePageMiguel(driver);
        assertTrue(game.isBoardVisible());
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}