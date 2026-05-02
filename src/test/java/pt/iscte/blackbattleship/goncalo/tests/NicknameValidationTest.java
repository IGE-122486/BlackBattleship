package pt.iscte.blackbattleship.goncalo.tests;

import pt.iscte.blackbattleship.goncalo.pages.GamePageGoncalo;
import pt.iscte.blackbattleship.pages.BattleshipHomePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NicknameValidationTest {

    @Test
    void testValidNickname() {

        WebDriver driver = new ChromeDriver();

        try {
            BattleshipHomePage home = new BattleshipHomePage(driver);
            home.open();
            home.acceptCookiesIfPresent();
            home.clickPlayVsRobot();

            GamePageGoncalo page = new GamePageGoncalo(driver);
            page.insertNickname("Goncalo123");
            page.submitNickname();

            assertTrue(page.isGameLoaded());

        } finally {
            driver.quit();
        }
    }
}