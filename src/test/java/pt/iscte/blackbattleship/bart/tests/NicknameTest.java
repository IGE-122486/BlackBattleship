package pt.iscte.blackbattleship.bart.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pt.iscte.blackbattleship.pages.BattleshipHomePage;
import pt.iscte.blackbattleship.bart.pages.GamePageBartolomeu;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NicknameTest {

    private WebDriver driver;
    private BattleshipHomePage homePage;
    private GamePageBartolomeu gamePage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        homePage = new BattleshipHomePage(driver);
        gamePage = new GamePageBartolomeu(driver);

        homePage.open();
        homePage.acceptCookiesIfPresent();
    }

    @Test
    void testValidNickname() {
        homePage.clickPlayVsRobot();

        gamePage.insertAndSubmitNickname("Bartolomeu123");

        assertTrue(gamePage.isGameLoaded());
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}