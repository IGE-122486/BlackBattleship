package pt.iscte.blackbattleship.miguel.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pt.iscte.blackbattleship.pages.BattleshipHomePage;
import pt.iscte.blackbattleship.miguel.pages.GamePageMiguel;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardVisibilityTest {

    private WebDriver driver;

    @Test
    void testBoardIsVisible() {
        driver = new ChromeDriver();

        BattleshipHomePage home = new BattleshipHomePage(driver);
        home.open();
        home.acceptCookiesIfPresent();

        home.clickPlayVsRobot();

        GamePageMiguel game = new GamePageMiguel(driver);
        game.enterNickname("Miguel");

        assertTrue(game.isBoardVisible());
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}