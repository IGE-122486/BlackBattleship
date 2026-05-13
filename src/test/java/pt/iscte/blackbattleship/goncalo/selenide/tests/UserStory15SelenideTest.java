package pt.iscte.blackbattleship.goncalo.selenide.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pt.iscte.blackbattleship.goncalo.selenide.pages.UserStory15Selenide;

/**
 * Classe de teste Selenide da User Story 15.
 *
 * Esta classe testa o regresso
 * à página inicial.
 *
 * @author Goncalo
 */
public class UserStory15SelenideTest {

    /**
     * Instância da Page Object.
     */
    private final UserStory15Selenide page =
            new UserStory15Selenide();

    /**
     * Configuração inicial.
     */
    @BeforeAll
    static void setUp() {

        Configuration.browser = "chrome";
        Configuration.browserSize = "1400x900";
        Configuration.timeout = 10000;
    }

    /**
     * Testa regresso à página inicial.
     */
    @Test
    public void returnToHomePageTest() {

        page.openWebsite();

        page.selectBattleshipGame();

        page.clickPlayVsRobot();

        page.enterNickname("Goncalo123");

        page.clickContinue();

        page.clickAbortButton();

        page.clickConfirmButton();

        page.clickHomeButton();
    }
}