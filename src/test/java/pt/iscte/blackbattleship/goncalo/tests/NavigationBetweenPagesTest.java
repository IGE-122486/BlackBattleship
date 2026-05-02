package pt.iscte.blackbattleship.goncalo.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pt.iscte.blackbattleship.pages.BattleshipHomePage;
import pt.iscte.blackbattleship.goncalo.pages.GamePageGoncalo;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NavigationBetweenPagesTest {

    @Test
    void testNavigationBetweenPages() {

        WebDriver driver = new ChromeDriver();

        try {
            // Página inicial
            BattleshipHomePage home = new BattleshipHomePage(driver);
            home.open();

            // validar que estamos na homepage
            assertTrue(driver.getCurrentUrl().contains("papergames.io"));

            home.acceptCookiesIfPresent();

            // navegar para jogo
            home.clickPlayVsRobot();

            GamePageGoncalo game = new GamePageGoncalo(driver);
            game.insertNickname("Goncalo123");
            game.submitNickname();

            // validar que mudou de página (jogo carregado)
            assertTrue(game.isGameLoaded());

        } finally {
            driver.quit();
        }
    }
}