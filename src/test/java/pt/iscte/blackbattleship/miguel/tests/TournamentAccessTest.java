package pt.iscte.blackbattleship.miguel.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pt.iscte.blackbattleship.pages.BattleshipHomePage;
import pt.iscte.blackbattleship.miguel.pages.TournamentPageMiguel;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TournamentAccessTest {

    private WebDriver driver;

    @Test
    void testOpenTournaments() throws InterruptedException {

        driver = new ChromeDriver();

        BattleshipHomePage home =
                new BattleshipHomePage(driver);

        home.open();

        home.acceptCookiesIfPresent();

        TournamentPageMiguel tournaments =
                new TournamentPageMiguel(driver);

        tournaments.openTournaments();

        Thread.sleep(1000);

        assertTrue(
                tournaments.isTournamentPageVisible()
        );

        assertTrue(
                tournaments.hasInteractiveElements()
        );
    }

    @AfterEach
    void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}