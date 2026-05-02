package pt.iscte.blackbattleship.goncalo.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pt.iscte.blackbattleship.pages.BattleshipHomePage;
import pt.iscte.blackbattleship.goncalo.pages.GamePageGoncalo;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmptyNicknameTest {

    @Test
    void testCannotStartWithoutNickname() {

        WebDriver driver = new ChromeDriver();

        try {
            BattleshipHomePage home = new BattleshipHomePage(driver);
            home.open();
            home.acceptCookiesIfPresent();
            home.clickPlayVsRobot();

            GamePageGoncalo game = new GamePageGoncalo(driver);

            // não inserir nickname → verificar botão desativado
            assertTrue(game.isContinueButtonDisabled());

        } finally {
            driver.quit();
        }
    }
}