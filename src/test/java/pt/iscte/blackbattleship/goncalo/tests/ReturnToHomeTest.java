package pt.iscte.blackbattleship.goncalo.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pt.iscte.blackbattleship.pages.BattleshipHomePage;
import pt.iscte.blackbattleship.goncalo.pages.GamePageGoncalo;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReturnToHomeTest {

    @Test
    void testReturnToHomePage() {

        WebDriver driver = new ChromeDriver();

        try {
            // abrir homepage
            BattleshipHomePage home = new BattleshipHomePage(driver);
            home.open();
            home.acceptCookiesIfPresent();
            home.clickPlayVsRobot();

            // entrar no jogo
            GamePageGoncalo game = new GamePageGoncalo(driver);
            game.insertNickname("Goncalo123");
            game.submitNickname();

            // voltar à homepage
            game.goToHomePage();

            // validar navegação
            driver.navigate().to("https://papergames.io/");

        } finally {
            driver.quit();
        }
    }
}