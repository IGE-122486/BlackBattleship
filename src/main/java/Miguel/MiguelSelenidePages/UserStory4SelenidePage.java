package Miguel.MiguelSelenidePages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

/**
 * Page Object da UserStory4SelenideTest.
 * US4 – Criar link de convite.
 */
public class UserStory4SelenidePage {

    public void openPage() {

        open("https://papergames.io/en/battleship");
    }

    public void acceptCookies() {

        $(".fc-cta-consent > .fc-button-label")
                .shouldBe(visible)
                .click();
    }

    public void clickPlayOnline() {

        $(".w-100:nth-child(1) .flex-grow-1")
                .shouldBe(visible)
                .click();
    }

    public void insertNickname(String nickname) {

        $(".input-xl")
                .shouldBe(visible)
                .setValue(nickname);
    }

    public void clickContinue() {

        $(".p-3 > .btn")
                .shouldBe(visible)
                .click();
    }

    public boolean inviteCreated() {

        return webdriver().driver().source()
                .toLowerCase()
                .contains("2000");
    }
}