package pt.iscte.blackbattleship.miguel.testsJavaDoc;

import Miguel.MiguelPages.UserStory2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Teste automático da UserStoryTest1.
 * US2 – Iniciar novo jogo.
 */
public class UserStory2Test {

    private WebDriver driver;

    @Test
    void testStartNewGame() throws InterruptedException {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        UserStory2 page =
                new UserStory2(driver);

        page.openPage();

        Thread.sleep(2000);

        page.rejectCookies();

        Thread.sleep(1000);

        page.clickPlay();

        Thread.sleep(1000);

        page.insertNickname("Miguel");

        Thread.sleep(1000);

        page.clickContinue();

        Thread.sleep(3000);

        assertTrue(page.gameStarted());
    }

    @AfterEach
    void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}