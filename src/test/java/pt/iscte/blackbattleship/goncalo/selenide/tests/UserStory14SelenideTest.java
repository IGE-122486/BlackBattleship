package pt.iscte.blackbattleship.goncalo.selenide.tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pt.iscte.blackbattleship.goncalo.selenide.pages.UserStory14Page;

/**
 * Classe de teste da User Story 14 usando Selenide.
 *
 * Esta classe testa se o sistema impede
 * o início do jogo sem nickname.
 *
 * @author Goncalo
 */
public class UserStory14SelenideTest {

    /**
     * Instância da Page Object.
     */
    private UserStory14Page userStory14Page;

    /**
     * Configuração inicial.
     */
    @BeforeEach
    public void setUp() {

        Configuration.browser = "chrome";

        Configuration.browserSize = "1920x1080";

        userStory14Page = new UserStory14Page();
    }

    @Description("Valida que o botão Continue fica desativado quando o nickname está vazio")
    /**
     * Testa tentativa de iniciar jogo sem nickname.
     */
    @Test
    public void validateEmptyNicknameTest() {

        userStory14Page.openWebsite();

        userStory14Page.selectTicTacToeGame();

        userStory14Page.clickPlayVsRobot();

        userStory14Page.validateContinueButtonDisabled();

    }
}