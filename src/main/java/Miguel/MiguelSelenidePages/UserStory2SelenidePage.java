package Miguel.MiguelSelenidePages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class UserStory2SelenidePage {

    public void openPage() {

        open("https://papergames.io/en/battleship");
    }

    public void rejectCookies() {

        $(".fc-cta-do-not-consent > .fc-button-label")
                .shouldBe(visible)
                .click();
    }

    public void clickPlay() {

        $(".w-100:nth-child(2) > .btn .flex-grow-1")
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

    public boolean gameStarted() {

        return webdriver().driver().source()
                .toLowerCase()
                .contains("2000");
    }
}