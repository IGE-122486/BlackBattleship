package pt.iscte.blackbattleship.goncalo.selenide.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

/**
 * Page Object da User Story 14 usando Selenide.
 *
 * Esta classe contém as operações necessárias
 * para validar que o jogo não começa sem nickname.
 *
 * @author Goncalo
 */
public class UserStory14Page {

    /**
     * Abre o website PaperGames.
     */
    public void openWebsite() {

        open("https://papergames.io/en/");
    }

    /**
     * Seleciona o jogo Tic Tac Toe.
     */
    public void selectTicTacToeGame() {

        $(".game-item:nth-child(2) .img-fluid").click();
    }

    /**
     * Seleciona a opção Play vs Robot.
     */
    public void clickPlayVsRobot() {

        $(".w-100:nth-child(1) .flex-grow-1").click();
    }

    /**
     * Tenta continuar sem nickname.
     */
    public void validateContinueButtonDisabled() {

        $(".p-3 > .btn").shouldBe(com.codeborne.selenide.Condition.disabled);
    }

    /**
     * Valida mensagem de erro.
     */
}