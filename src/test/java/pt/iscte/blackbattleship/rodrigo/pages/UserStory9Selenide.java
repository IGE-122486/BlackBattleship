package pt.iscte.blackbattleship.rodrigo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

/**
 * Page Object Class da User Story 9 usando Selenide.
 *
 * User Story 9:
 * Como utilizador, quero conseguir aceder às páginas
 * de termos e privacidade para consultar informação legal do serviço.
 *
 * @author Rodrigo
 */
public class UserStory9Selenide {

    private final SelenideElement privacyLink =
            $x("//a[contains(., 'Privacy') or contains(., 'Terms')]");

    public void openWebsite() {
        open("https://papergames.io/en/");
    }

    public void clickPrivacyLink() {
        privacyLink.click();
    }
}