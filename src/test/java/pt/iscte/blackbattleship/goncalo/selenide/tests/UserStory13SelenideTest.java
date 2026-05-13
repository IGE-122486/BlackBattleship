package pt.iscte.blackbattleship.goncalo.selenide.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pt.iscte.blackbattleship.goncalo.selenide.pages.UserStory13Selenide;

/**
 * Classe de teste Selenide da User Story 13.
 *
 * Esta classe testa a validação
 * de nickname com Selenide.
 *
 * @author Goncalo
 */
public class UserStory13SelenideTest {

    /**
     * Instância da Page Object.
     */
    private final UserStory13Selenide page =
            new UserStory13Selenide();

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
     * Testa nickname válido.
     */
    @Test
    public void validateValidNicknameTest() {

        page.openWebsite();

        page.selectBattleshipGame();

        page.clickPlayVsRobot();

        page.enterNickname("Goncalo123");

        page.clickContinue();
    }
}