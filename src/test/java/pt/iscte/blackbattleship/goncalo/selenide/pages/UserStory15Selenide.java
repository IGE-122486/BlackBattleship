package pt.iscte.blackbattleship.goncalo.selenide.pages;
import static com.codeborne.selenide.Selectors.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

/**
 * Page Object Class Selenide da User Story 15.
 *
 * Esta classe contém operações de interação
 * usando o framework Selenide.
 *
 * @author Goncalo
 */
public class UserStory15Selenide {

    /**
     * Abre o website PaperGames.
     */
    public void openWebsite() {

        open("https://papergames.io/en/");
    }

    /**
     * Seleciona Battleship.
     */
    public void selectBattleshipGame() {

        $(".game-item:nth-child(1) .img-fluid")
                .shouldBe(visible)
                .click();
    }

    /**
     * Seleciona Play vs Robot.
     */
    public void clickPlayVsRobot() {

        $(".w-100:nth-child(2) > .btn > .front")
                .shouldBe(visible)
                .click();
    }

    /**
     * Introduz nickname.
     *
     * @param nickname nickname do jogador
     */
    public void enterNickname(String nickname) {

        $(".input-xl")
                .shouldBe(visible)
                .setValue(nickname);
    }

    /**
     * Clica em Continue.
     */
    public void clickContinue() {

        $(".p-3 > .btn")
                .shouldBe(enabled)
                .click();
    }

    /**
     * Aborta o jogo.
     */
    public void clickAbortButton() {

        $x("//*[contains(text(),'Abort')]")
                .shouldBe(visible)
                .click();
    }

    /**
     * Confirma abandono do jogo.
     */
    public void clickConfirmButton() {

        $(".btn-danger")
                .shouldBe(visible)
                .click();
    }

    /**
     * Volta à página inicial.
     */
    public void clickHomeButton() {

        $(byLinkText("Home"))
                .shouldBe(visible)
                .click();
    }
}