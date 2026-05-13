package pt.iscte.blackbattleship.goncalo.selenide.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pt.iscte.blackbattleship.goncalo.selenide.pages.UserStory16Selenide;

/**
 * Classe de teste Selenide da User Story 16.
 *
 * Esta classe testa a navegação
 * entre páginas do jogo.
 *
 * @author Goncalo
 */
public class UserStory16SelenideTest {

    /**
     * Instância da Page Object.
     */
    private final UserStory16Selenide page =
            new UserStory16Selenide();

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
     * Testa navegação entre páginas.
     */
    @Test
    public void navigationBetweenPagesTest() {

        page.openWebsite();

        page.selectBattleship();
        page.clickHomeButton();

        page.selectTicTacToe();
        page.clickHomeButton();

        page.selectConnect4();
        page.clickHomeButton();

        page.selectGomoku();
        page.clickHomeButton();

        page.selectChess();
        page.clickHomeButton();

        page.selectLastGame();
        page.clickHomeButton();
    }
}