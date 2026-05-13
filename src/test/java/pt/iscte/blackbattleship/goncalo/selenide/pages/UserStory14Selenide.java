package pt.iscte.blackbattleship.goncalo.selenide.pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

/**
 * Page Object Class Selenide da User Story 14.
 *
 * Esta classe contém operações de interação
 * usando o framework Selenide.
 *
 * @author Goncalo
 */
public class UserStory14Selenide {

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

        $(".game-item:nth-child(2) .text-light")
                .shouldBe(visible)
                .click();
    }

    /**
     * Seleciona o modo de jogo.
     */
    public void clickPlayButton() {

        $(".w-100:nth-child(2) > .btn .flex-grow-1")
                .shouldBe(visible)
                .click();
    }

    /**
     * Fecha a janela.
     */
    public void clickCancelButton() {

        $(".mat-mdc-button-touch-target")
                .shouldBe(visible)
                .click();
    }
}