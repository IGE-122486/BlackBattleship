package Miguel.MiguelSelenidePages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

/**
 * Page Object da UserStory17SelenideTest.
 * US17 - Validar abertura da loja no site.
 */
public class UserStory17SelenidePage {

    public void openHomePage() {

        open("https://papergames.io/en/battleship");
    }

    public void acceptCookies() {

        $(".fc-cta-consent > .fc-button-label")
                .shouldBe(visible)
                .click();
    }

    public void openShop() {

        $$("span")
                .findBy(text("Shop"))
                .shouldBe(visible)
                .click();
    }

    public boolean isCoinsButtonVisible() {

        try {

            $$("a")
                    .findBy(text("Coins"))
                    .shouldBe(visible);

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    public boolean isShopPageOpened() {

        return webdriver().driver().source()
                .toLowerCase()
                .contains("coins");
    }
}