package pt.iscte.blackbattleship.goncalo.selenide.pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;

/**
 * Page Object Class Selenide da User Story 16.
 *
 * Esta classe contém operações de interação
 * usando o framework Selenide.
 *
 * @author Goncalo
 */
public class UserStory16Selenide {

    /**
     * Abre o website PaperGames.
     */
    public void openWebsite() {

        open("https://papergames.io/en/");
    }

    /**
     * Seleciona Battleship.
     */
    public void selectBattleship() {

        sleep(1500);

        $(".game-item:nth-child(1) .img-fluid")
                .shouldBe(visible)
                .click();
    }

    /**
     * Seleciona Tic Tac Toe.
     */
    public void selectTicTacToe() {

        $(".game-item:nth-child(2) .img-fluid")
                .shouldBe(visible)
                .click();
    }

    /**
     * Seleciona Connect 4.
     */
    public void selectConnect4() {

        $(".game-item:nth-child(3) .img-fluid")
                .shouldBe(visible)
                .click();
    }

    /**
     * Seleciona Gomoku.
     */
    public void selectGomoku() {

        $(".game-item:nth-child(4) .img-fluid")
                .shouldBe(visible)
                .click();
    }

    /**
     * Seleciona Chess.
     */
    public void selectChess() {

        $(".game-item:nth-child(5) .thumbnail")
                .shouldBe(visible)
                .click();
    }

    /**
     * Seleciona último jogo.
     */
    public void selectLastGame() {

        $(".game-item:nth-child(6) .img-fluid")
                .shouldBe(visible)
                .click();
    }

    /**
     * Volta à página inicial.
     */
    public void clickHomeButton() {

        sleep(2000);

        $(byLinkText("Home"))
                .shouldBe(visible)
                .click();
    }
}