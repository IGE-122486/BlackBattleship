package pt.iscte.blackbattleship.rodrigo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

/**
 * Page Object Class da User Story 11 usando Selenide.
 *
 * @author Rodrigo
 */
public class UserStory11Selenide {

    private final SelenideElement battleshipGame =
            $x("(//*[contains(@class, 'game-item')])[1]");

    private final SelenideElement shareOption =
            $x("//*[contains(., 'Share') or contains(., 'Invite')]");

    public void openWebsite() {
        open("https://papergames.io/en/");
    }

    public void selectBattleshipGame() {
        battleshipGame.click();
    }

    public boolean isShareOptionVisible() {
        return shareOption.exists();
    }
}