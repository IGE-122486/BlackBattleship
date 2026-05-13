package Miguel.MiguelSelenidePages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

/**
 * Page Object da UserStory18SelenideTest.
 * US18 – Validar acesso aos meus torneios.
 */
public class UserStory18SelenidePage {

    public void openPage() {

        open("https://papergames.io/en/battleship");
    }

    public void acceptCookies() {

        $(".fc-cta-consent > .fc-button-label")
                .shouldBe(visible)
                .click();
    }

    public void openMyTournaments() {

        $$("span")
                .findBy(text("My tournaments"))
                .shouldBe(visible)
                .click();
    }

    public boolean tournamentsPageOpened() {

        return webdriver().driver().source()
                .toLowerCase()
                .contains("tournament");
    }
}