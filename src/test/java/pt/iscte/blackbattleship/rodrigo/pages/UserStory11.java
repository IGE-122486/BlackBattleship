package pt.iscte.blackbattleship.rodrigo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object Class da User Story 11.
 *
 * User Story 11:
 * "Como utilizador, quero visualizar opções de partilha
 * para poder enviar ou divulgar o jogo a outras pessoas."
 *
 * @author Rodrigo
 */
public class UserStory11 {

    private final WebDriver driver;

    private final By shareOption =
            By.xpath("//*[contains(., 'Invite') or contains(., 'Share')]");

    public UserStory11(WebDriver driver) {
        this.driver = driver;
    }

    public void openWebsite() {
        driver.get("https://papergames.io/en/battleship");
    }

    public boolean isShareOptionVisible() {
        return driver.findElement(shareOption).isDisplayed();
    }
}