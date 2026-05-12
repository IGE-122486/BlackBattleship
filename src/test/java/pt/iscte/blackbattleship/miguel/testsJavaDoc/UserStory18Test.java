package pt.iscte.blackbattleship.miguel.testsJavaDoc;

import MiguelPages.UserStory18;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Teste automático da UserStoryTest4.
 * US18 – Validar acesso aos meus torneios.
 */
public class UserStory18Test {

    private WebDriver driver;

    @Test
    void testTournamentAccess() throws InterruptedException {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        UserStory18 page =
                new UserStory18(driver);

        page.openPage();

        Thread.sleep(2000);

        page.acceptCookies();

        Thread.sleep(1000);

        page.openMyTournaments();

        Thread.sleep(3000);

        assertTrue(page.tournamentsPageOpened());
    }

    @AfterEach
    void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}