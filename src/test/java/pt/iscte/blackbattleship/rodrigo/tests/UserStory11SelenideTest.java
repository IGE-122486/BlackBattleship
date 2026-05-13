package pt.iscte.blackbattleship.rodrigo.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.iscte.blackbattleship.rodrigo.pages.UserStory11Selenide;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Classe de teste da User Story 11 usando Selenide.
 *
 * @author Rodrigo
 */
public class UserStory11SelenideTest {

    private UserStory11Selenide page;

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1389x793";
        page = new UserStory11Selenide();
    }

    @Test
    public void shareOptionVisibleTest() {
        page.openWebsite();

        page.selectBattleshipGame();

        sleep(2000);

        assertTrue(page.isShareOptionVisible());
    }
}