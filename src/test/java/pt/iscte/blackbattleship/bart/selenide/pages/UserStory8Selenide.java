package pt.iscte.blackbattleship.bart.selenide.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.*;

/**
 * Page Object Class for UserStory8 using Selenide.
 * Represents the flow where a user starts a robot Battleship game.
 */
public class UserStory8Selenide {

    /**
     * Opens the PaperGames homepage.
     */
    public void openHomePage() {
        open("https://papergames.io/en/");
    }

    /**
     * Accepts the consent popup if it is visible.
     */
    public void acceptConsentIfVisible() {
        if ($(".fc-cta-consent > .fc-button-label").exists()) {
            $(".fc-cta-consent > .fc-button-label").click();
            sleep(700);
        }
    }

    /**
     * Opens the Battleship game page.
     */
    public void openBattleshipGame() {
        $("img[alt='Battleship']")
                .shouldBe(Condition.visible)
                .click();

        sleep(700);
    }

    /**
     * Selects the robot game mode.
     */
    public void selectRobotGame() {
        $(".w-100:nth-child(2) > .btn .flex-grow-1")
                .shouldBe(Condition.visible)
                .click();

        sleep(700);
    }

    /**
     * Inserts the nickname.
     *
     * @param nickname nickname to insert.
     */
    public void typeNickname(String nickname) {
        $(".input-xl")
                .shouldBe(Condition.visible)
                .clear();

        $(".input-xl")
                .setValue(nickname);

        sleep(700);
    }

    /**
     * Confirms the nickname.
     */
    public void confirmNickname() {
        $(".p-3 > .btn")
                .shouldBe(Condition.visible)
                .click();

        sleep(1800);
    }

    /**
     * Checks whether the generated game room was opened.
     *
     * @return true if the URL contains /en/r/.
     */
    public boolean isGameRoomOpened() {
        return webdriver().driver().url().contains("/en/r/");
    }
}