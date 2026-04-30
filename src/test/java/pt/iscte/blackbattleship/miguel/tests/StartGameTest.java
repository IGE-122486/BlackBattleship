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
    void testStartNewGame() {
        driver = new ChromeDriver();

        BattleshipHomePage home = new BattleshipHomePage(driver);
        home.open();

        // 1. aceitar cookies automaticamente
        home.acceptCookiesIfPresent();

        // 2. clicar play vs robot
        home.clickPlayVsRobot();

        // 3. inserir nickname automaticamente
        GamePageMiguel game = new GamePageMiguel(driver);
        game.enterNickname("Miguel");

        // 4. validar jogo
        assertTrue(game.isBoardVisible());
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}