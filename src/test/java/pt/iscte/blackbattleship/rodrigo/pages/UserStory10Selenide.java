package pt.iscte.blackbattleship.rodrigo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

/**
 * Page Object Class da User Story 10 usando Selenide.
 *
 * @author Rodrigo
 */
public class UserStory10Selenide {

    private final SelenideElement languageButton =
            $x("//*[contains(., 'EN') or contains(., 'English')]");

    public void openWebsite() {
        open("https://papergames.io/en/");
    }

    public void clickLanguageButton() {
        languageButton.click();
    }
}