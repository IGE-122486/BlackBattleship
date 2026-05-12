package pt.iscte.blackbattleship.rodrigo.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.iscte.blackbattleship.rodrigo.pages.UserStory12Selenide;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Classe de teste da User Story 12 usando Selenide.
 *
 * @author Rodrigo
 */
public class UserStory12SelenideTest {

    private UserStory12Selenide page;

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1389x793";
        page = new UserStory12Selenide();
    }

    @Test
    public void accessPaperGamesHomePageTest() {
        page.openWebsite();

        page.selectBattleshipGame();

        sleep(1000);

        page.clickHomeButton();

        sleep(1000);

        String url = webdriver().driver().url();

        assertTrue(url.contains("papergames.io"));
    }
}